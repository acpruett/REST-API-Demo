package com.apruett;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class that helps to run the SpringBoot application. The annotation
 * provided allows the class to recognize that this is a Spring Boot
 * project and run accordingly.
 *
 * @author Anna Pruett
 */
@SpringBootApplication
public class MainApplicationClass
{
    /**
     * Main class that helps to run the SpringBoot application.
     *
     * @param args The arguments on the command line
     */
    public static void main(String[] args)
    {
        SpringApplication.run(MainApplicationClass.class, args);
    }
}
