package com.epam.ivankaliada.BasicSpringApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.epam.ivankaliada.BasicSpringApp"})
@SpringBootApplication
@EntityScan("com.epam.ivankaliada.BasicSpringApp.entity")
public class BasicSpringAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicSpringAppApplication.class, args);
    }

}
