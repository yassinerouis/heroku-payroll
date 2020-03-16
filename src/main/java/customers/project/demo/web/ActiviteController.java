package customers.project.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import customers.project.demo.entities.Activite;
import customers.project.demo.services.ActiviteService;

@RestController
@CrossOrigin
public class ActiviteController {
	@Autowired
	ActiviteService activiteservice;
	@PostMapping("/saveactivite/{id_status}/{id_phase}/{id_prerequis}")
	public void save(@RequestBody Activite activite,@PathVariable int id_status,@PathVariable String id_phase,@PathVariable String id_prerequis) {
		System.out.println(id_prerequis);
		activiteservice.addActivite(activite,id_status,id_phase,id_prerequis);
	}
	@PostMapping("/saveactivite/{id_status}/{id_phase}")
	public void saveFirst(@RequestBody Activite activite,@PathVariable int id_status,@PathVariable String id_phase) {
		activiteservice.addFirstActivite(activite,id_status,id_phase);
	}
}