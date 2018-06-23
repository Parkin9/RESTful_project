package pl.parkin9.restful_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages={"pl.parkin9.restful_project"})
public class RestfulProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulProjectApplication.class, args);
	}
}
