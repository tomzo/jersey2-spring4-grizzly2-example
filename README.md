# Jersey 2.25 + Spring 4.3.7 + grizzly 2.3.30

Based on [official example](https://github.com/jersey/jersey/tree/2.25.x/examples/helloworld-spring-annotations) but with newer dependencies,
 specifically Spring 4 instead of 3.

## Standalone demo

Create a fat jar with maven:
```
mvn package
```

Start server
```console
$ java -jar target/jersey-spring-1.0.0.jar
"Hello World" Jersey-Spring Example com.ai_traders.examples.jersey_spring.App
Apr 04, 2017 2:59:32 PM org.springframework.context.annotation.AnnotationConfigApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@4d591d15: startup date [Tue Apr 04 14:59:32 UTC 2017]; root of context hierarchy
Apr 04, 2017 2:59:32 PM org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor <init>
INFO: JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
Apr 04, 2017 2:59:35 PM org.glassfish.grizzly.http.server.NetworkListener start
INFO: Started listener bound to [0.0.0.0:8080]
Apr 04, 2017 2:59:35 PM org.glassfish.grizzly.http.server.HttpServer start
INFO: [HttpServer] Started.
Application started.
Try out http://0.0.0.0:8080/base/spring
```

Browse to `http://localhost:8080/base/spring`
