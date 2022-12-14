package com.ulas.gplacesproject.constant;


import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public enum ErrorConstants {
    INVALID_OPERATION(BAD_REQUEST, "0002"),
    NOT_FOUND(HttpStatus.NOT_FOUND,"0002")
    ;


    private final HttpStatus httpStatus;
    private final String codes;

    ErrorConstants(HttpStatus status, String codes) {
        this.httpStatus = status;
        this.codes = codes;
    }
}
