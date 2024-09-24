package net.javaguides.springboot;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("net.javaguides.springboot")
public class SpringBootSocialBattery {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSocialBattery.class, args);
	}

}