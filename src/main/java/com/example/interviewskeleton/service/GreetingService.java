package com.example.interviewskeleton.service;

import com.example.interviewskeleton.properties.GreetingProperties;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Map;

@Service
public class GreetingService {

    private final GreetingProperties greetingProperties;

    public GreetingService(final GreetingProperties greetingProperties) {
        this.greetingProperties = greetingProperties;
    }

    public String getGreeting(final String name, final String locale) {
        String greeting = switch (getTimeOfDay()) {
            case "morning" -> getGreetingForTimeOfDay(greetingProperties.getMorning(), locale);
            case "afternoon" -> getGreetingForTimeOfDay(greetingProperties.getAfternoon(), locale);
            case "evening" -> getGreetingForTimeOfDay(greetingProperties.getEvening(), locale);
            default -> "Hello, {name}!";
        };

        return greeting.replace("{name}", name);
    }

    private String getTimeOfDay() {
        int hour = LocalTime.now().getHour();
        if (hour >= 6 && hour < 12) return "morning";
        else if (hour >= 12 && hour < 18) return "afternoon";
        else return "evening";
    }

    private String getGreetingForTimeOfDay(final Map<String, String> greetings, final String locale) {
        return greetings.getOrDefault(locale, "Hello, {name}!");
    }
}
