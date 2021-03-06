package customers.project.demo.web;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import customers.project.demo.entities.Modele;
import customers.project.demo.entities.Population;
import customers.project.demo.entities.ResponsabiliteModele;
import customers.project.demo.services.ModeleService;
import customers.project.demo.services.ResponsabiliteModeleService;

@RestController
@CrossOrigin

public class ModeleController {
		@Autowired
		ModeleService modeleservice;
		@Autowired
		ResponsabiliteModeleService responsabilitemodeleservice;
		
		@PostMapping("/savemodele/{type}/{responsable}")
		public Modele save(@RequestBody Modele modele,@PathVariable int type,@PathVariable String responsable) {
			Modele m=modeleservice.addModele(modele,type);			
			responsabilitemodeleservice.addResponsabilite(responsable, modele);
			return m;
		}
		
		@GetMapping("/getmodeles")
		public List<Modele> getAll() {
			return modeleservice.getModeles();
		}
		@GetMapping("/getmodeles/{reglementation}")
		public List<Modele> getModeles(@PathVariable String reglementation) {
			return modeleservice.getModeles(reglementation);
		}
		@GetMapping("/getModelesForResponsable/{matricule}")
		public List<Modele> getModelesForResponsable(@PathVariable String matricule) {
			return modeleservice.getModelesForResponsable(matricule);
		}
		@GetMapping("/getresponsablemodele/{id_modele}")
		public ResponsabiliteModele getResponsable(@PathVariable long id_modele) {
			return responsabilitemodeleservice.getResponsable(id_modele);
		}
		
		@PutMapping("/updatemodele/{type}/{responsable}")
		public Modele updateModeleRespo(@RequestBody Modele modele,@PathVariable int type,@PathVariable String responsable) {
			System.out.println(responsable);
			Modele m=modeleservice.updateModele(modele,type);
			responsabilitemodeleservice.updateResponsabilite(modele, responsable);
			return m;
		}
		
		@DeleteMapping("/deleteModele/{id}")
		public void delete(@PathVariable("id") long id) {
			modeleservice.deleteModele(id);
		}		
}
