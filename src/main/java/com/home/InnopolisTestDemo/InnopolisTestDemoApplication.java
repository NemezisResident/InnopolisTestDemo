package com.home.InnopolisTestDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class InnopolisTestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnopolisTestDemoApplication.class, args);
	}

}
