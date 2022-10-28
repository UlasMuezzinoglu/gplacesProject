package com.ulas.gplacesproject.util;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Component
@NoArgsConstructor
public class MethodUtils {

    public static Date getCurrentDate() {
        return Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
    }

}
