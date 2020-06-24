package customers.project.demo.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.databind.ObjectMapper;

import customers.project.demo.entities.CompteUtilisateur;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		System.out.println("hi");

		//recuperer les donnees de l'utilisateur
		CompteUtilisateur user = null;		
		try {
			user = new ObjectMapper().readValue(request.getInputStream(), CompteUtilisateur.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		System.out.println("***********************");
		System.out.println("username: "+user.getUsername());
		System.out.println("password: "+user.getPassword());
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		User springuser = (User) authResult.getPrincipal();
		System.out.println("ggg");
		//Generate the token
		String jwt = Jwts.builder()
					.setSubject(springuser.getUsername())
					.setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
					.signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
					.claim("roles", springuser.getAuthorities())
					.compact();
		
		//add the token to the response
		response.addHeader(SecurityConstants.HEADER, SecurityConstants.TOKEN_PREFIX+jwt);
	}

}
