package mymoneymanager.backend.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"mymoneymanager.backend"}) 
@EnableJpaRepositories(basePackages = {
	    "mymoneymanager.backend.repository"
	})
@EntityScan(basePackages = "mymoneymanager.backend.model")
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
