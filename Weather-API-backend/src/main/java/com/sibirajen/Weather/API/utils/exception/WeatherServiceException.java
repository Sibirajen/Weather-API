package com.sibirajen.Weather.API.utils.exception;

import com.sibirajen.Weather.API.service.WeatherService;

public class WeatherServiceException extends RuntimeException{
    public WeatherServiceException(String msg, Throwable cause){
        super(msg, cause);
    }

    public WeatherServiceException(String msg){
        super(msg);
    }
}
