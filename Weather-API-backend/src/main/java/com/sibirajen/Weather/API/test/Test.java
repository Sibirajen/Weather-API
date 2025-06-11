package com.sibirajen.Weather.API.test;

import lombok.Getter;

public class Test {
    @Getter
    private static String response = "{\n" +
            "    \"request\": {\n" +
            "        \"type\": \"City\",\n" +
            "        \"query\": \"Delhi, Canada\",\n" +
            "        \"language\": \"en\",\n" +
            "        \"unit\": \"m\"\n" +
            "    },\n" +
            "    \"location\": {\n" +
            "        \"name\": \"Delhi\",\n" +
            "        \"country\": \"Canada\",\n" +
            "        \"region\": \"Ontario\",\n" +
            "        \"lat\": \"42.850\",\n" +
            "        \"lon\": \"-80.500\",\n" +
            "        \"timezone_id\": \"America/Toronto\",\n" +
            "        \"localtime\": \"2025-06-09 02:22\",\n" +
            "        \"localtime_epoch\": 1749435720,\n" +
            "        \"utc_offset\": \"-4.0\"\n" +
            "    },\n" +
            "    \"current\": {\n" +
            "        \"observation_time\": \"06:22 AM\",\n" +
            "        \"temperature\": 16,\n" +
            "        \"weather_code\": 116,\n" +
            "        \"weather_icons\": [\n" +
            "            \"https://cdn.worldweatheronline.com/images/wsymbols01_png_64/wsymbol_0004_black_low_cloud.png\"\n" +
            "        ],\n" +
            "        \"weather_descriptions\": [\n" +
            "            \"Partly cloudy\"\n" +
            "        ],\n" +
            "        \"astro\": {\n" +
            "            \"sunrise\": \"05:46 AM\",\n" +
            "            \"sunset\": \"09:03 PM\",\n" +
            "            \"moonrise\": \"08:05 PM\",\n" +
            "            \"moonset\": \"04:08 AM\",\n" +
            "            \"moon_phase\": \"Waxing Gibbous\",\n" +
            "            \"moon_illumination\": 95\n" +
            "        },\n" +
            "        \"air_quality\": {\n" +
            "            \"co\": \"514.3\",\n" +
            "            \"no2\": \"19.98\",\n" +
            "            \"o3\": \"52\",\n" +
            "            \"so2\": \"4.44\",\n" +
            "            \"pm2_5\": \"49.95\",\n" +
            "            \"pm10\": \"50.69\",\n" +
            "            \"us-epa-index\": \"3\",\n" +
            "            \"gb-defra-index\": \"3\"\n" +
            "        },\n" +
            "        \"wind_speed\": 11,\n" +
            "        \"wind_degree\": 145,\n" +
            "        \"wind_dir\": \"SE\",\n" +
            "        \"pressure\": 1005,\n" +
            "        \"precip\": 0,\n" +
            "        \"humidity\": 88,\n" +
            "        \"cloudcover\": 75,\n" +
            "        \"feelslike\": 16,\n" +
            "        \"uv_index\": 0,\n" +
            "        \"visibility\": 24,\n" +
            "        \"is_day\": \"no\"\n" +
            "    }\n" +
            "}";
}
