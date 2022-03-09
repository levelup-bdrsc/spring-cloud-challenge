package br.com.caelum.eats.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EatsServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EatsServiceRegistryApplication.class, args);
	}

}
