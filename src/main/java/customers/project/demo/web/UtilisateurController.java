package customers.project.demo.web;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import customers.project.demo.entities.CompteUtilisateur;
import customers.project.demo.entities.Pays;
import customers.project.demo.entities.Utilisateur;
import customers.project.demo.security.JWTAuthenticationFilter;
import customers.project.demo.services.CompteService;
import customers.project.demo.services.UtilisateurService;
@RestController
@CrossOrigin
public class UtilisateurController {
	public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads/utilisateurs/";
	@Autowired
	 UtilisateurService utilisateurservice;
	@Autowired
	CompteService compteservice;
	@PostMapping("/changePdp/{user_id}")
	public void save(@RequestParam("file") MultipartFile file,@PathVariable String user_id) {
		System.out.println(file.getName());
		try {
			StringBuilder fileNames = new StringBuilder();
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename()+" ");
			Files.write(fileNameAndPath, file.getBytes());
			utilisateurservice.getUtilisateur(user_id).setPhoto(file.getOriginalFilename());
			utilisateurservice.updateutilisateur(utilisateurservice.getUtilisateur(user_id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
	@PostMapping("/saveutilisateur")
	public void save(@RequestBody Utilisateur utilisateur) {
		utilisateurservice.addutilisateur(utilisateur);
	}
	@GetMapping("/getutilisateurs")
	public List<Utilisateur> getAll() {
		return utilisateurservice.getutilisateur();
	}
	@GetMapping("/getUtilisateur/{matricule}")
	public Utilisateur getUser(@PathVariable String matricule) {
		return utilisateurservice.getUtilisateur(matricule);
	}
	@GetMapping("/getUser/{email}")
	public Utilisateur login(@PathVariable String email) {
		return compteservice.findUser(email);
	}
	@PutMapping("/updateutilisateur")
	public void updateutilisateur(@RequestBody Utilisateur utilisateur) {
		
		utilisateurservice.updateutilisateur(utilisateur);
	}
	@DeleteMapping("/deleteutilisateur/{id}")
	public void delete(@PathVariable("id") String id) {
		utilisateurservice.deleteutilisateur(id);
	}
	
}
