package com.sibirajen.Weather.API.component;

import com.sibirajen.Weather.API.dto.WeatherResponse;
import com.sibirajen.Weather.API.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class WeatherController {
    private final WeatherService service;

    @Autowired
    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/weather/{city}")
    public ResponseEntity<WeatherResponse> helloWorld(@PathVariable String city){
        System.out.print("Endpoint : ");
        return ResponseEntity.ok(service.getWeather(city));
    }
}
