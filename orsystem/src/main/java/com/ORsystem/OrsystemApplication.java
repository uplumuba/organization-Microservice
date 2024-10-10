package com.ORsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication()

public class OrsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrsystemApplication.class, args);
	}

}
