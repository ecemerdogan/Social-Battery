package net.javaguides.springboot.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.javaguides.springboot.model.WeatherInfo;


@Service
public class WeatherService {
    private final String apiKey = "4ca95dfc5a0230bd77216478e652aa62";
    private final String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=";

    public WeatherInfo getWeatherInfo(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + city + "&appid=" + apiKey;
        ResponseEntity<WeatherInfo> response = restTemplate.getForEntity(url, WeatherInfo.class);
        return response.getBody();
    }
}
