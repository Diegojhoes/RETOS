package web.app.motos1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import web.app.motos1.service.MotorbikeController;

@SpringBootApplication
@ComponentScan(basePackageClasses = MotorbikeController.class)
public class WebappmotosApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebappmotosApplication.class, args);
	}

}
