package com.ai_traders.examples.jersey_spring;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.ws.rs.core.Application;

import static org.junit.Assert.*;

public class SpringRequestResourceIntegrationTest extends JerseyTest {

    @Override
    protected Application configure() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);
        return new JerseyConfig().property("contextConfig", context);
    }

    @Test
    public void test() {
        final String hello = target("spring").request().get(String.class);
        assertEquals("hello, world 1!", hello);
    }

}