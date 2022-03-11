package br.com.caelum.eats.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EatConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EatConfigServerApplication.class, args);
	}

}
