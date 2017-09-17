package com.kodgemisi;


import com.kodgemisi.service.impl.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

@SpringBootApplication
public class DemoApplication {


	@Resource
	StorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}





}

