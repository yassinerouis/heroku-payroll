package customers.project.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import customers.project.demo.entities.Population;
import customers.project.demo.services.PopulationService;

@RestController
@CrossOrigin

public class PopulationController {
	@Autowired
	PopulationService populationservice;
	@PostMapping("/savepopulation/{type}")
	public void save(@RequestBody Population population,@PathVariable String type) {
		populationservice.addPopulation(population,type);
	}
	@GetMapping("/getpopulations")
	public List<Population> getAll() {
		return populationservice.getPopulations();
	}
	@PutMapping("/updatepopulation/{type}")
	public void updateModele(@RequestBody Population population,@PathVariable String type) {
		populationservice.updatePopulation(population,type);	
	}
}
