package com.sibirajen.Weather.API.utils;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("cityKeyGenerator")
public class CityKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
        if (params.length > 0 && params[0] instanceof String) {
            String city = ((String) params[0]).replaceAll("\\s+", "").toUpperCase();
            System.out.println("city : " + city);
            return city;
        }
        return "";
    }
}
