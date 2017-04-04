package com.ai_traders.examples.jersey_spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Integration of jersey and spring.
 * This rest controller is a singleton spring bean with an autowired depency
 * from spring
 *
 * Original author Geoffroy Warin (http://geowarin.github.io)
 * see https://github.com/jersey/jersey/blob/2.25.x/examples/helloworld-spring-annotations/src/main/java/org/glassfish/jersey/examples/hello/spring/annotations/SpringRequestResource.java
 */
@Singleton
@Path("spring")
@Service
public class SpringRequestResource {

    AtomicInteger counter = new AtomicInteger();

    @Autowired
    private GreetingService greetingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return greetingService.greet("world " + counter.incrementAndGet());
    }

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}