package com.ulas.gplacesproject.core;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class LoggingBean {
    public Logger
            service = LoggerFactory.getLogger("service"),
            admin = LoggerFactory.getLogger("admin"),
            activity = LoggerFactory.getLogger("activity"),
            performance = LoggerFactory.getLogger("performance"),
            util = LoggerFactory.getLogger("util"),
            database = LoggerFactory.getLogger("database"),
            attempt = LoggerFactory.getLogger("attempt"),
            filter = LoggerFactory.getLogger("filter");
}
