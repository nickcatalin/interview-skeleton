package com.example.interviewskeleton.controller;

import com.example.interviewskeleton.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService greetingService;

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable final String name, @RequestParam(defaultValue = "en") final String locale) {
        return greetingService.getGreeting(name, locale);
    }
}
