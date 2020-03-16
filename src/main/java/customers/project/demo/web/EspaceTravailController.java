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

import customers.project.demo.entities.EspaceTravail;
import customers.project.demo.services.EspaceTravailService;

	@RestController
	@CrossOrigin
	public class EspaceTravailController {
		@Autowired
		 EspaceTravailService EspaceTravailservice;
		@PostMapping("/saveEspaceTravail")
		public void save(@RequestBody EspaceTravail EspaceTravail) {
			EspaceTravailservice.addEspaceTravail(EspaceTravail);
		}
		@GetMapping("/getEspaceTravail")
		public List<EspaceTravail> getAll() {
			return EspaceTravailservice.getEspaceTravail();
		}
		@PutMapping("/updateEspaceTravail")
		public void updateEspaceTravail(@RequestBody EspaceTravail EspaceTravail) {
			EspaceTravailservice.updateEspaceTravail(EspaceTravail);
		}
		@DeleteMapping("/deleteEspaceTravail/{id}")
		public void delete(@PathVariable("id") int id) {
			EspaceTravailservice.deleteEspaceTravail(id);
		}
	}