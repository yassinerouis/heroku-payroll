package customers.project.demo.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import customers.project.demo.entities.Population;
import customers.project.demo.entities.Suivi;
import customers.project.demo.services.ModeleService;
import customers.project.demo.services.SuiviService;

@RestController
@CrossOrigin

public class SuiviController {
	@Autowired
	ModeleService modeleservice;
	@Autowired
	SuiviService suiviservice;
	@GetMapping("/getpopulations/{modele}")
	public Set<Population> getPopulations(@PathVariable long modele) {
		return modeleservice.getPopulations(modele);
	}
	@GetMapping("/getsuivis")
	public void getSuivis() {
	}
	@PostMapping("/savesuivi")
	public void save(@RequestBody Suivi suivi) {
		suiviservice.savesuivi(suivi);
	}
}
