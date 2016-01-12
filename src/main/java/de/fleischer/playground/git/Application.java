package de.fleischer.playground.git;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * Created by fleischer on 12.01.16.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // Create application context
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        System.out.println("Let's inspection teh beans provided by Spring Boot:");

        // Get initialed beans
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beanNames);

        // Print initialed beans
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
