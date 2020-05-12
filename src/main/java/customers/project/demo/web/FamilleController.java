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

import customers.project.demo.entities.Famille;
import customers.project.demo.services.FamilleService;

@RestController
@CrossOrigin
public class FamilleController {
	@Autowired
	 FamilleService Familleservice;
	@PostMapping("/savefamille")
	public void save(@RequestBody Famille famille) {
		Familleservice.addFamille(famille);
	}
	@GetMapping("/getfamille")
	public List<Famille> getAll() {
		return Familleservice.getFamille();
	}
	@PutMapping("/updatefamille")
	public void updateFamille(@RequestBody Famille famille) {
		Familleservice.updateFamille(famille);
	}
	@DeleteMapping("/deletefamille/{id}")
	public void delete(@PathVariable("id") int id) {
		Familleservice.deleteFamille(id);
	}
}
