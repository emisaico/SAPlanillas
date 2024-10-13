package pe.com.utp.service.uit.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/*import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;*/

@SpringBootApplication
@ComponentScan({"pe.com.utp.service.uit"})
public class UitApplication {
	public static void main(String[] args) {
		SpringApplication.run(UitApplication.class, args);
	}
	
}