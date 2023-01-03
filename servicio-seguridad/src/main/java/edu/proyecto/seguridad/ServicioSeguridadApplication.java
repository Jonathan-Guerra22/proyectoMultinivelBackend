package edu.proyecto.seguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServicioSeguridadApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioSeguridadApplication.class, args);
	}

}
