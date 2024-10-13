package pe.com.utp.service.support.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"pe.com.utp.service.support.auth"})
public class AuthSupportApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthSupportApplication.class, args);
	}

}
