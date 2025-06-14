package com.sibirajen.Weather.API.utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class WeatherStack {
    public static URI getURL(String city) {
        Dotenv env = Dotenv.load();
        String apiKey = env.get("WEATHER_API_KEY");
        String baseUrl = env.get("WEATHER_API_URL");
        String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
        String units = "m";
        String language = "en";

        try {
            return new URI(baseUrl + "?access_key=" +  apiKey + "&query=" + encodedCity);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
