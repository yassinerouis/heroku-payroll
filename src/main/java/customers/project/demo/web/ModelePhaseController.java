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
import customers.project.demo.entities.ModelePhase;
import customers.project.demo.services.ModelePhaseService;

@RestController
@CrossOrigin
public class ModelePhaseController {
	@Autowired
	ModelePhaseService modelephaseservice;
	@PostMapping("/savemodelephase/{phase}/{modele}")
	public void savePhase(@PathVariable String phase,@PathVariable String modele) {
		modelephaseservice.addModelePhase(phase,modele);
	}
	@GetMapping("/getmodelesphases")
	public List<ModelePhase> getAll() {
		return modelephaseservice.getModelePhases();
	}
	
	@PutMapping("/updateModelePhase")
	public void updateModele(@RequestBody ModelePhase modelephase) {
		modelephaseservice.updateModele(modelephase);
	}
	
	@DeleteMapping("/deleteModelePhase/{id}")
	public void delete(@PathVariable("id") Long id) {
		modelephaseservice.deleteModele(id);
	}		
	
}
