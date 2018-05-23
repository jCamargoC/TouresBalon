package com.touresbalon.orders.ordersmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.touresbalon"})
public class OrdersManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersManagerApplication.class, args);
	}
}
