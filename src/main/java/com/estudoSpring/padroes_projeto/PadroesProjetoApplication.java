package com.estudoSpring.padroes_projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients // Habilita feign
@SpringBootApplication
public class PadroesProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesProjetoApplication.class, args);
	}

}
