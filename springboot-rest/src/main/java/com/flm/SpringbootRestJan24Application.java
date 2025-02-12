package com.flm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootRestJan24Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestJan24Application.class, args);
	}

}
