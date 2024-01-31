package project3.newfoodfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NewfoodfinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewfoodfinderApplication.class, args);
	}

}
