package br.com.caelum.eats.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EatsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EatsEurekaServerApplication.class, args);
	}

}
