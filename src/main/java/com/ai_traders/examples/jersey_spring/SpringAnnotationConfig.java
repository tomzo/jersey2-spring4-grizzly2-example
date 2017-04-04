package com.ai_traders.examples.jersey_spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {GreetingService.class})
public class SpringAnnotationConfig {
}