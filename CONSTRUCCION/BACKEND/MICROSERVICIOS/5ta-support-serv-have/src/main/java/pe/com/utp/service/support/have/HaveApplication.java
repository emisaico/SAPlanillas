package pe.com.utp.service.support.have;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"pe.com.utp.service.support.have"})
public class HaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaveApplication.class, args);
	}

}
