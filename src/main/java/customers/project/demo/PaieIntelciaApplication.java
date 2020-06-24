package customers.project.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PaieIntelciaApplication {
	//return an instance of bcrypte because spring boot does not do it automatically
		@Bean
		public BCryptPasswordEncoder getBCPE() {
			return new BCryptPasswordEncoder();
		}
	public static void main(String[] args) {
		SpringApplication.run(PaieIntelciaApplication.class, args);
	}

}
