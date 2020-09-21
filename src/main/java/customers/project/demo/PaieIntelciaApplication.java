package customers.project.demo;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import customers.project.demo.entities.CompteUtilisateur;
import customers.project.demo.entities.Configuration;
import customers.project.demo.entities.Role;
import customers.project.demo.entities.Utilisateur;
import customers.project.demo.services.CompteService;
import customers.project.demo.services.RoleService;
import customers.project.demo.services.UtilisateurService;

@SpringBootApplication
public class PaieIntelciaApplication{
	@Autowired
	RepositoryRestConfiguration repository;

	//return an instance of bcrypte because spring boot does not do it automatically
		@Bean
		
		public BCryptPasswordEncoder getBCPE() {
			return new BCryptPasswordEncoder();
		}
		
	public static void main(String[] args) {
		SpringApplication.run(PaieIntelciaApplication.class, args);
				
		/*SpringApplication application = new SpringApplication(PaieIntelciaApplication.class);
        Properties properties = new Properties();
        properties.put("server.port", 9999);
        application.setDefaultProperties(properties);
        application.run(args);
        properties.put("server.port", 9999);
        properties.put("spring.datasource.url","jdbc:mysql://localhost:3306/intelcia_db");
        application.setDefaultProperties(properties);
        application.run(args);*/
	}
	/*@Bean
	CommandLineRunner start(RepositoryRestConfiguration repository) {
			return args ->{
				repository.exposeIdsFor(Configuration.class);
			};
			}
	@Bean
	CommandLineRunner start(RoleService roleservice,CompteService compteservice,UtilisateurService userservice) {
		return args->{
			Role role1=new Role();
			role1.setRole("Admin");
			roleservice.addRole(role1);
			CompteUtilisateur compte=new CompteUtilisateur();
			compte.setRole(role1);
			Utilisateur user=new Utilisateur();
			user.setMatricule("EEEE00");
			user.setNom("Admin");
			user.setPrenom("Admin");
			user.setEmploi("ADMIN DU GROUPE");
			user.setRole("Admin");
			userservice.addutilisateur(user);
			compte.setUtilisateur(user);
			compte.setUsername("admin@gmail.com");
			compte.setPassword("admin");
			compteservice.save(compte);
		};
		}*/
	
}
