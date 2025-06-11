package com.sibirajen.Weather.API.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private Request request;
    private Location location;
    private Current current;

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Request {
        private String type;
        private String query;
    }

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location {
        private String name;
        private String country;
        private String localtime;
    }

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Current {
        private int temperature;
        private List<String> weather_descriptions;
        private List<String> weather_icons;
        private int wind_speed;
        private int humidity;
    }
}
