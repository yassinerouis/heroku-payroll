package customers.project.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import customers.project.demo.entities.Population;
import customers.project.demo.services.ResponsabiliteModeleService;

@RestController
@CrossOrigin

public class ResponsabiliteModeleController {
	@Autowired
	ResponsabiliteModeleService responsabilitemodeleservice;
	/*@PostMapping("/saveResponsabiliteModele/{modele}/{responsable}")
	public void save(@PathVariable long modele,@PathVariable String responsable) {
		responsabilitemodeleservice.addResponsabilite(responsable, modele);
	}*/
}
