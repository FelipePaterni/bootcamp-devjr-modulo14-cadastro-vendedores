package com.vendedores.backend_vendedores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BackendVendedoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendVendedoresApplication.class, args);
	}

}
