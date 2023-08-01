package com.example.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {
    @GetMapping("/weather")
    public String index() {
        System.out.println("Get Request: Weather");
        return "Weather Controller";
    }

    @GetMapping("/weather-gov")
    public String weathergov() {
        System.out.println("Get Request: Weather Gov2");
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("https://api.weather.gov/gridpoints/TOP/31,80/forecast", String.class);
        return result;
    }
    @GetMapping("/weather-alert")
    public String weatherGovAlert() {
        System.out.println("Get Request: Weather Gov Alert");
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("https://api.weather.gov/alerts/active?area=GA", String.class);
        return result;
    }

}
