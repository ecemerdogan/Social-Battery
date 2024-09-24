package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Choices;
import net.javaguides.springboot.model.Questions;
import net.javaguides.springboot.model.Scores;
import net.javaguides.springboot.repository.ChoicesRepository;
import net.javaguides.springboot.repository.QuestionRepository;
import net.javaguides.springboot.repository.ScoreRepository;

@Service
public class SurveyImpl implements SurveyService{
    private final QuestionRepository questionRepository;
    private final ChoicesRepository choicesRepository;
    private final ScoreRepository scoreRepository;

    @Autowired
    public SurveyImpl(QuestionRepository questionRepository,ChoicesRepository choicesRepository,ScoreRepository scoreRepository) {
        this.questionRepository = questionRepository;
        this.choicesRepository = choicesRepository;
        this.scoreRepository = scoreRepository;
    }

    public List<Questions> getAllQuestions() {
        return questionRepository.findAll();
    }
    public List<Choices> getAllChoices() {
        return choicesRepository.findAll();
    }
    /*
    public int getResult(List<Questions> questions) {
        int totalScore = 0;

        for (Questions question : questions) {
            Choices chosenChoice = question.getChosenChoice();
            
            if (chosenChoice != null) {
                totalScore += chosenChoice.getScore();
            }
        }

        return totalScore;
    }*/
    public int getResult(List<Long> selectedChoiceIds) {
        int totalScore = 0;

        for (Long choiceId : selectedChoiceIds) {
            Choices chosenChoice = choicesRepository.findById(choiceId).orElse(null);

            if (chosenChoice != null) {
                totalScore += chosenChoice.getScore();
            }
        }

        return totalScore;
    }
    
    public void saveScore(Scores score) {
		Scores saveResult = new Scores();
		saveResult.setUser(score.getUser());
		saveResult.setUserScore(score.getUserScore());
		scoreRepository.save(saveResult);
	}
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		return null;
	}

	@Override
	public String getAll() {
	
		return null;
	}
}