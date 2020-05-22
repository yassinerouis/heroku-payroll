package customers.project.demo.web;

import java.util.ArrayList;
import java.util.HashSet;
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
import customers.project.demo.entities.Activite;
import customers.project.demo.entities.Modele;
import customers.project.demo.services.ActiviteService;
import customers.project.demo.services.ResponsabiliteActiviteService;

@RestController
@CrossOrigin
public class ActiviteController {
	@Autowired
	ActiviteService activiteservice;
	@Autowired
	ResponsabiliteActiviteService responsabiliteactiviteservice;
	@PostMapping("/saveactivite/{prerequis}")
	public void save(@RequestBody Activite activite,@PathVariable long prerequis[]) {
		Set<Activite> activities=new HashSet<Activite>();
		for(int i=0;i<prerequis.length;i++) {
			activities.add(activiteservice.getActivite(prerequis[i]));
		}
		activite.setPrecedente(activities);
		activiteservice.addActivite(activite);
		}
	@PostMapping("/saveactivite")
	public void saveFirst(@RequestBody Activite activite) {
		activiteservice.addActivite(activite);
		}
	@GetMapping("/getactivites")
	public List<Activite> getAll() {
		return activiteservice.getActivites();
	}
	@GetMapping("/getactivites/{id_phase}")
	public List<Activite> getActivites(@PathVariable long id_phase) {
		return activiteservice.selectActivites(id_phase);
	}
	@GetMapping("/getprerequis/{id_activite}")
	public Set<Activite> getPrerequis(@PathVariable long id_activite) {
		return activiteservice.getPrerequis(id_activite);
	}
	@PutMapping("/updateactivite/{prerequis}")
	public void updateActivite(@RequestBody Activite activite,@PathVariable long prerequis[]) {
		Set<Activite> activities=new HashSet<Activite>();
		for(int i=0;i<prerequis.length;i++) {
			activities.add(activiteservice.getActivite(prerequis[i]));
		}
		activite.setPrecedente(activities);
		activiteservice.updateActivite(activite);
	}
	@PutMapping("/updateactivite")
	public void updateFirstActivite(@RequestBody Activite activite) {
		activiteservice.updateActivite(activite);
	}
	/*@PutMapping("/updateactivite/{responsable}")
	public void updateModeleRespo(@RequestBody Activite activite,@PathVariable String responsable[]) {
		activiteservice.updateActivite(activite);
		for(int i=0;i<responsable.length;i++) {
		responsabiliteactiviteservice.updateResponsabilite(activite, responsable[i]);
		}
	}*/
	@DeleteMapping("/deleteActivite/{id}")
	public void delete(@PathVariable("id") long id) {
		activiteservice.deleteActivite(id);
	}		
}