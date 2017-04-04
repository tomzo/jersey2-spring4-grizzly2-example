[![Build Status](https://travis-ci.org/tomzo/jersey2-spring4-grizzly2-example.svg?branch=master)](https://travis-ci.org/tomzo/jersey2-spring4-grizzly2-example)

# Jersey 2.25 + Spring 4.3.7 + grizzly 2.3.30

Based on [official example](https://github.com/jersey/jersey/tree/2.25.x/examples/helloworld-spring-annotations) but with newer dependencies,
 specifically Spring 4 instead of 3.

This is an opinionated example of getting all parts working together, which can be hard. Some main points:

 * Java 8
 * Project should be deployed as self-hosting (fat) jar.
 * Tests should easily run on CLI `mvn test` or `gradle test` and in graphical IDE (IntelliJ).
 * There should be unit tests where we can mock any selected service and using mockito for verification
 * There should be integration tests were we rely on spring to compose entire server
 * I prefer gradle over maven, but this example has configured both build systems

## Standalone demo

Create a fat jar with maven:
```
mvn package
```
Or with gradle
```
./gradlew fatJar
```

Start server (maven output is at `target/jersey-spring-1.0.0.jar`, gradle `build/libs/jersey-spring-1.0.0.jar`)
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

# Sources

 * https://github.com/jersey/jersey/tree/2.25.x/examples/helloworld-spring-annotations
 * https://github.com/Hylke1982/jersey2-spring-test-example
 * http://stackoverflow.com/questions/32264431/how-to-write-a-test-case-for-jersey-rest-resouce-grizzlymockito
