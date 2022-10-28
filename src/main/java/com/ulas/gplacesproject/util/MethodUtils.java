package com.ulas.gplacesproject.util;

import com.ulas.gplacesproject.exception.CustomException;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@NoArgsConstructor
public class MethodUtils {

    public static Date getCurrentDate() {
        return Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
    }

    public static Object prepareErrorJSON(final HttpStatus status, final Exception ex) {
        Map respond = new HashMap();
        System.out.println("ex.getMessage(): " + ex.getMessage());
        respond.put("status", status.value());
        respond.put("error", status.getReasonPhrase());
        respond.put("code", ex.getMessage());
        respond.put("time", ZonedDateTime.now(ZoneId.of("Z")));
        if (!(ex instanceof CustomException)) {
            respond.put("code", "0500");
        }
        return respond;
    }

}
