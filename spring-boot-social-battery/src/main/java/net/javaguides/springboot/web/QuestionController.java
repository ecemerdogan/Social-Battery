package net.javaguides.springboot.web;

import net.javaguides.springboot.model.Choices;
import net.javaguides.springboot.model.Events;
import net.javaguides.springboot.model.Questions;
import net.javaguides.springboot.model.Scores;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.ChoicesRepository;
import net.javaguides.springboot.repository.EventsRepository;
import net.javaguides.springboot.repository.QuestionRepository;
import net.javaguides.springboot.repository.ScoreRepository;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.SurveyImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {
    private final QuestionRepository questionRepository;
    private final ChoicesRepository choicesRepository;
    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository;
    private final EventsRepository eventsRepository;
    
    @Autowired
    SurveyImpl surveyService;
    
    @Autowired
    Scores score;
    
    Boolean submitted = false;

    @Autowired
    public QuestionController(QuestionRepository questionRepository, ChoicesRepository choicesRepository,ScoreRepository scoreRepository,UserRepository userRepository,EventsRepository eventsRepository) {
        this.questionRepository = questionRepository;
        this.choicesRepository = choicesRepository;
        this.scoreRepository = scoreRepository;
        this.userRepository = userRepository;
        this.eventsRepository = eventsRepository;
        
    }
    
    @ModelAttribute("score")
    public Scores getResult() {
    return score;
   }

    @GetMapping("/questions")
    public String getQuestions(Model model) {
        List<Questions> questionsList = questionRepository.findAll();
        model.addAttribute("questions", questionsList);
        
        List<Choices> choicesList = choicesRepository.findAll();
        model.addAttribute("choices", choicesList);
        return "survey"; // Assuming your Thymeleaf template is named "survey.html"
    }
    
    
    
    @PostMapping("/submit")
    public String submit(@RequestParam("answers") List<Long> selectedChoiceIds) {
    	if (!submitted) {
            List<Choices> chosenChoices = new ArrayList<>();

            // Retrieve the selected choices using their IDs
            for (Long choiceId : selectedChoiceIds) {
                Choices choice = choicesRepository.findById(choiceId).orElse(null);
                if (choice != null) {
                    chosenChoices.add(choice);
                }
            }
            

            // Calculate the user's score using the service's getResult() method
            int totalScore = surveyService.getResult(selectedChoiceIds);

            // Get the currently logged-in user's ID
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            User user = userRepository.findByEmail(username);
            if (user == null) {

            } else {
                // Save the score in the Scores class with the user's ID
                score.setUser(user);
                score.setUserScore(totalScore);
                surveyService.saveScore(score);
            }

            submitted = true;
        }

        return "redirect:/";
    
    }
    
    @GetMapping("/submit")
    public String getEvents(Model model) {
    	List<Events> eventsList = eventsRepository.findAll();
        model.addAttribute("events", eventsList);
        return "event"; 
  }
}
