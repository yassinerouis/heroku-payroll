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

import customers.project.demo.entities.Activite;
import customers.project.demo.entities.Phase;
import customers.project.demo.services.PhaseService;

@RestController
@CrossOrigin
public class PhaseController {
	@Autowired
	PhaseService phaseservice;
	@PostMapping("/savephase/{famille}")
	public void savePhase(@RequestBody Phase phase,@PathVariable int famille) {
		phaseservice.addPhase(phase,famille);
	}
	
	@GetMapping("/getphases")
	public List<Phase> getAll() {
		return phaseservice.getPhases();
	}
	@GetMapping("/getactivities")
	public Set<Activite> getActivities(@RequestBody Phase phase) {
		return phaseservice.getActivites(phase);
	}
	
	@PutMapping("/updatePhase")
	public void updateModele(@RequestBody Phase phase) {
		phaseservice.updatePhase(phase);
	}
	
	@DeleteMapping("/deletePhase/{id}")
	public void delete(@PathVariable("id") long id) {
		phaseservice.deletePhase(id);
	}		
	
}
