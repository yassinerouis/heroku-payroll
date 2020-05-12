package customers.project.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import customers.project.demo.entities.Utilisateur;
import customers.project.demo.services.UtilisateurService;
@RestController
@CrossOrigin
public class UtilisateurController {
	@Autowired
	 UtilisateurService utilisateurservice;
	@PostMapping("/saveutilisateur")
	public void save(@RequestBody Utilisateur utilisateur) {
		utilisateurservice.addutilisateur(utilisateur);
	}
	@GetMapping("/getutilisateurs")
	public List<Utilisateur> getAll() {
		return utilisateurservice.getutilisateur();
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
