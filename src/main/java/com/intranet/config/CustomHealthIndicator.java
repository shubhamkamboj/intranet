package com.intranet.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        // Add custom logic here (e.g. ping internal service)
        boolean healthy = true;
        if (healthy) {
            return Health.up().withDetail("customService", "Available").build();
        } else {
            return Health.down().withDetail("customService", "Unavailable").build();
        }
    }
}
