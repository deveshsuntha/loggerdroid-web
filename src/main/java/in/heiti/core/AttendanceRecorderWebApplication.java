package in.heiti.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages= {"in.heiti.entity"})
@ComponentScan(basePackages= {"in.heiti.controllers",
		"in.heiti.services"})
@EnableJpaRepositories(basePackages="in.heiti.services")
public class AttendanceRecorderWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceRecorderWebApplication.class, args);
	}
}
