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

import customers.project.demo.entities.Frequence;
import customers.project.demo.services.FrequenceService;

@RestController
@CrossOrigin
public class FrequenceController {
	@Autowired
	 FrequenceService frequenceservice;
	@PostMapping("/savefrequence")
	public void save(@RequestBody Frequence frequence) {
		frequenceservice.addFrequence(frequence);
	}
	@GetMapping("/getfrequence")
	public List<Frequence> getAll() {
		return frequenceservice.getFrequence();
	}
	@PutMapping("/updatefrequence")
	public void updateFrequence(@RequestBody Frequence Frequence) {
		frequenceservice.updateFrequence(Frequence);
	}
	@DeleteMapping("/deletefrequence/{id}")
	public void delete(@PathVariable("id") int id) {
		frequenceservice.deleteFrequence(id);
	}
}
