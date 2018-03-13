package com.airtel.problem.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.airtel.*" })
public class ServiceMain {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ServiceMain.class, args);
	}
}
