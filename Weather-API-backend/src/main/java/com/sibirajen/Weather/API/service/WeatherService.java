package com.sibirajen.Weather.API.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sibirajen.Weather.API.dto.WeatherResponse;
import com.sibirajen.Weather.API.utils.exception.WeatherServiceException;
import com.sibirajen.Weather.API.utils.WeatherStack;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class WeatherService {
    @Cacheable(value = "Weather", key = "#city.toUpperCase()")
    public WeatherResponse getWeather(String city) {
        URI uri = WeatherStack.getURL(city);
        System.out.println(uri);
        try {
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .timeout(Duration.ofSeconds(30))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() != 200){
                throw new WeatherServiceException("API Error " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            WeatherResponse dto = mapper.readValue(response.body(), WeatherResponse.class);
//            WeatherResponse dto = mapper.readValue(Test.getResponse(), WeatherResponse.class);
            System.out.println(dto);
            return dto;
        } catch (IOException | InterruptedException e) {
            throw new WeatherServiceException("Failed to fetch weather", e);
        }
    }
}
