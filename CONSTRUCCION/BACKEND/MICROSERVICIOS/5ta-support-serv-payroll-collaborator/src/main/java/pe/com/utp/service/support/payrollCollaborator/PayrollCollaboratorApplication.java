package pe.com.utp.service.support.payrollCollaborator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"pe.com.utp.service.support.payrollCollaborator"})
public class PayrollCollaboratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollCollaboratorApplication.class, args);
	}

}
