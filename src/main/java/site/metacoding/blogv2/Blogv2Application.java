package site.metacoding.blogv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Blogv2Application {

	public static void main(String[] args) {
		SpringApplication.run(Blogv2Application.class, args);
	}

}
