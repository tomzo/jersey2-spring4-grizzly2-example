package com.ai_traders.examples.jersey_spring;

import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.ServletDeploymentContext;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * In this test we verify http resource handling while mocking away potentially complex 'Greeting service'
 */
public class SpringRequestResourceTest extends JerseyTest {
    @Mock
    private GreetingService mockGreetingService;
    private SpringRequestResource resource;

    @Override
    protected TestContainerFactory getTestContainerFactory() {
        return new GrizzlyWebTestContainerFactory();
    }

    @Override
    public DeploymentContext configureDeployment() {
        resource = new SpringRequestResource();
        MockitoAnnotations.initMocks(this);
        resource.setGreetingService(mockGreetingService);

        ServletDeploymentContext context
                = ServletDeploymentContext.forServlet(
                new ServletContainer(new JerseyConfig().register(resource).property(
                        ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, "true")))
                .build();
        return context;
    }

    @Test
    public void httpGetCallsGreetingService() {
        when(mockGreetingService.greet(any(String.class))).thenReturn("Hi from mock!");
        final String hello = target("spring").request().get(String.class);
        assertEquals("Hi from mock!", hello);
        verify(mockGreetingService, times(1)).greet("world 1");
    }
}