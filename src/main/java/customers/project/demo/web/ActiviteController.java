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
	@PostMapping("/saveactivite/{id_status}/{id_phase}/{id_prerequis}/{espace}/{responsable}")
	public void save(@RequestBody Activite activite,@PathVariable int id_status,@PathVariable long id_phase,@PathVariable long id_prerequis, @PathVariable int espace,@PathVariable String responsable[]) {
		activiteservice.addActivite(activite,id_status,id_phase,id_prerequis,espace);
		for(int i=0;i<responsable.length;i++) {
		responsabiliteactiviteservice.addResponsabilite(responsable[i], activite);
		}
	}
	@PostMapping("/saveactivite/{id_status}/{id_phase}/{espace}/{responsable}")
	public void saveFirst(@RequestBody Activite activite,@PathVariable int id_status,@PathVariable long id_phase,@PathVariable int espace,@PathVariable String responsable[]) {
		activiteservice.addFirstActivite(activite,id_status,id_phase,espace);
		for(int i=0;i<responsable.length;i++) {
		responsabiliteactiviteservice.addResponsabilite(responsable[i], activite);
		}
	}
	@GetMapping("/getactivites")
	public List<Activite> getAll() {
		return activiteservice.getActivites();
	}
	@GetMapping("/getactivites/{id_phase}")
	public List<Activite> getActivites(@PathVariable long id_phase) {
		return activiteservice.selectActivites(id_phase);
	}
	@PutMapping("/updateactivite")
	public void updateActivite(@RequestBody Activite activite) {
		activiteservice.updateActivite(activite);
	}
	/*@PutMapping("/updateactivite/{responsable}")
	public void updateModeleRespo(@RequestBody Activite activite,@PathVariable String responsable[]) {
		activiteservice.updateActivite(activite);
		for(int i=0;i<responsable.length;i++) {
		responsabiliteactiviteservice.updateResponsabilite(activite, responsable[i]);
		}
	}*/
	@DeleteMapping("/deleteactivite/{id}")
	public void delete(@PathVariable("id") long id) {
		activiteservice.deleteActivite(id);
	}		
}