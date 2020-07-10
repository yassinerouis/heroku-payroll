package customers.project.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import customers.project.demo.entities.CompteUtilisateur;
import customers.project.demo.services.CompteService;
@RestController
@CrossOrigin
public class CompteController {
@Autowired
private CompteService compteservice;
@PostMapping("/savecompte")
public void AddCompte(@RequestBody CompteUtilisateur compte) {
	compteservice.save(compte);
}
	
}
