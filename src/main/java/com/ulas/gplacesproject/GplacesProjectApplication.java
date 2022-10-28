package com.ulas.gplacesproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EntityScan(basePackages = {"com.ulas.gplacesproject.model.entity"})
@SpringBootApplication(scanBasePackages = "com.ulas.gplacesproject")
public class GplacesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GplacesProjectApplication.class, args);
	}

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
