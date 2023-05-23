package com.azhar.SpringApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

	// swagger doc will be available on http://localhost:8080/swagger-ui.html#

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
