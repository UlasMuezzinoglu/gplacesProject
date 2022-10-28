package com.ulas.gplacesproject.config;


import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@EnableMongoAuditing(dateTimeProviderRef = "dateTimeProvider")
public class AuditorAwareConfig implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("VISITOR"); // Spring Security not implemented yet
    }
}
