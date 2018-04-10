package com.touresbalon.b2c.clientsmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.touresbalon","com.touresbalon.common.security"})
public class ClientsManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientsManagerApplication.class, args);
	}
}
