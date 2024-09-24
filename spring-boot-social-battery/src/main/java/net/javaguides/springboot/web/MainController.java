package net.javaguides.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.model.WeatherInfo;
import net.javaguides.springboot.service.WeatherService;

@Controller
public class MainController {
	@Autowired
	private WeatherService weatherService;

	
	//login 
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
    public String home(Model model) {
        String city = "istanbul"; 
        WeatherInfo weatherInfo = weatherService.getWeatherInfo(city);
        model.addAttribute("weatherInfo", weatherInfo);
        return "index";
    }
	}

