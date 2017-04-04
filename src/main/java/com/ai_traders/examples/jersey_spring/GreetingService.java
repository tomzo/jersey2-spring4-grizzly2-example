package com.ai_traders.examples.jersey_spring;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String greet(String who) {
        return String.format("hello, %s!", who);
    }
}
