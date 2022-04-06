package com.maxeluds.hrconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class HrconfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrconfigserverApplication.class, args);
	}

}
