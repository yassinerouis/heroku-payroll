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
import customers.project.demo.services.ModelePhaseService;
import customers.project.demo.services.ModeleService;
import customers.project.demo.services.ResponsabiliteModeleService;

@RestController
@CrossOrigin

public class ModeleController {
	
		@Autowired
		ModeleService modeleservice;
		@Autowired
		ModelePhaseService modelephaseservice;
		@Autowired
		ResponsabiliteModeleService responsabilitemodeleservice;

		@PostMapping("/savemodele/{type}/{type_paie}/{frequence}/{phases}/{responsable}")
		
		public void save(@RequestBody Modele modele,@PathVariable int type,@PathVariable int type_paie,@PathVariable int frequence,@PathVariable long phases[],@PathVariable String responsable) {
			modeleservice.addModele(modele,type,type_paie,frequence);
			System.out.println(responsable);
			for(int i=0;i<phases.length;i++) {
				
				modelephaseservice.addModelePhase(phases[i], modele.getCode_modele());
			}
			responsabilitemodeleservice.addResponsabilite(responsable, modele);
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
			System.out.println(id);
			modeleservice.deleteModele(id);
		}		
}
