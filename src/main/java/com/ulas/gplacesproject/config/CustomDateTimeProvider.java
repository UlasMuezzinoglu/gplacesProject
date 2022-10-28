package com.ulas.gplacesproject.config;

import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.stereotype.Component;

import java.time.temporal.TemporalAccessor;
import java.util.Optional;

import static com.ulas.gplacesproject.util.MethodUtils.getCurrentDate;

@Component("dateTimeProvider")
public class CustomDateTimeProvider implements DateTimeProvider {

    @Override
    public Optional<TemporalAccessor> getNow() {
        return Optional.of(getCurrentDate().toInstant());
    }
}
