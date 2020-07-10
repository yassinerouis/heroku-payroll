package customers.project.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		//J'utilise JWTAuthorization filter que j'ai créé
		http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		//Je definie des droits d'accès
		//the register API is accessible without authentication
		http.authorizeRequests().antMatchers("/","/**").permitAll();
		//http.authorizeRequests().antMatchers("/","/admin/**").hasAuthority("Payroll manager");
		//Don't let users adding shops to the DB unless they have the role ADMIN
		//http.authorizeRequests().antMatchers(HttpMethod.POST,"/shops/**").hasAuthority("ADMIN");
		
		//We don't need the session offered by spring because we will work with JWT
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		//all APIs require authentication 
		http.authorizeRequests().anyRequest().authenticated();
		
		//We use the JWTAuthentication filter that we created
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
				
	}
	
}
