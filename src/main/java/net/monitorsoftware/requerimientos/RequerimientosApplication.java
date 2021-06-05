package net.monitorsoftware.requerimientos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RequerimientosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequerimientosApplication.class, args);
	}

}
