package gob.nucleo.plantaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan({"gob.nucleo.beneficiariocommons.entity", "gob.nucleo.usuariocommons.entity", "gob.nucleo.plantacommons.entity"})
@SpringBootApplication
public class PlantaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantaServiceApplication.class, args);
	}

}
