package com.epam.ivankaliada.BasicSpringApp.monitor;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Endpoint(id = "customHealth")
public class CustomHealthEndpoint {

    @ReadOperation
    public Health getHealth() {
        if (isDbHealthy()) {
            return Health.up().withDetail("External Db svc ", "Healthy").build();
        } else {
            return Health.down().withDetail("External Db svc ", "Is Not-healthy").build();
        }
    }

    private boolean isDbHealthy() {
        Random random = new Random();
        return random.nextBoolean();
    }

}
