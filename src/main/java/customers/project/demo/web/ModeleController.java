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
import customers.project.demo.services.ModeleService;

@RestController
@CrossOrigin

public class ModeleController {
	
		@Autowired
		ModeleService modeleservice;
		@PostMapping("/savemodele/{type}/{frequence}")
		public void save(@RequestBody Modele modele,@PathVariable String type,@PathVariable int frequence) {
			modeleservice.addModele(modele,type,frequence);
		}
		
		@GetMapping("/getmodeles")
		public List<Modele> getAll() {
			return modeleservice.getModeles();
		}
		
		@PutMapping("/updateModele")
		public void updateModele(@RequestBody Modele modele) {
			modeleservice.updateModele(modele);
		}
		
		@DeleteMapping("/deleteModele/{id}")
		public void delete(@PathVariable("id") String id) {
			System.out.println(id);
			modeleservice.deleteModele(id);
		}		
}
