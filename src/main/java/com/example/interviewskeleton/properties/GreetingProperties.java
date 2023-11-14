package com.example.interviewskeleton.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "greeting")
@Getter
@Setter
public class GreetingProperties {
    private Map<String, String> morning;
    private Map<String, String> afternoon;
    private Map<String, String> evening;
}
