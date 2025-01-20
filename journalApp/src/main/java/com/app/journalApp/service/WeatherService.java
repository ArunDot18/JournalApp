package com.app.journalApp.service;

import com.app.journalApp.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    private static final String apiKey = "8713f77dee31ab7646cbd6c24043cb9a";

    private static final String API = "https://api.openweathermap.org/data/2.5/weather?q=CITY&appid=APIKEY&units=metric";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city){
        String finaAPI = API.replace("CITY", city).replace("APIKEY", apiKey);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finaAPI, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }


}
