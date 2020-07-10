package customers.project.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import customers.project.demo.entities.CompteUtilisateur;
import customers.project.demo.entities.Role;
import customers.project.demo.services.CompteService;
import customers.project.demo.services.RoleService;

@SpringBootApplication
public class PaieIntelciaApplication implements CommandLineRunner{
	@Autowired
	RoleService roleservice;
	@Autowired
	CompteService compteservice;
	//return an instance of bcrypte because spring boot does not do it automatically
		@Bean
		
		public BCryptPasswordEncoder getBCPE() {
			return new BCryptPasswordEncoder();
		}
		
	public static void main(String[] args) {
		SpringApplication.run(PaieIntelciaApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Role role1=new Role();
		role1.setRole("Admin");
		Role role2=new Role();
		role2.setRole("Payroll");
		Role role3=new Role();
		role3.setRole("Payroll manager");
		Role role4=new Role();
		role4.setRole("RRH");
		CompteUtilisateur compte=new CompteUtilisateur();
		compte.setUsername("admin@gmail.com");
		compte.setPassword("admin");
		compte.setRole(role1);
		compteservice.save(compte);*/
	}
}
