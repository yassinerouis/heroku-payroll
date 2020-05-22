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

import customers.project.demo.entities.Modele;
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
		@GetMapping("/getresponsablemodele")
		public ResponsabiliteModele getAll(Modele modele) {
			return responsabilitemodeleservice.getResponsable(modele.getCode_modele());
		}
		
		@PutMapping("/updateModele/{responsable}")
		public void updateModeleRespo(@RequestBody Modele modele,@PathVariable String responsable) {
			System.out.println(responsable);
			modeleservice.updateModele(modele);
			responsabilitemodeleservice.updateResponsabilite(modele, responsable);
		}
		@PutMapping("/updateModele")
		public void updateModele(@RequestBody Modele modele) {
			modeleservice.updateModele(modele);
		}
		
		@DeleteMapping("/deleteModele/{id}")
		public void delete(@PathVariable("id") long id) {
			modeleservice.deleteModele(id);
		}		
}
