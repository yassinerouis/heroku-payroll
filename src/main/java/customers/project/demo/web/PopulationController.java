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
import customers.project.demo.entities.Population;
import customers.project.demo.services.PopulationService;

@RestController
@CrossOrigin

public class PopulationController {
	@Autowired
	PopulationService populationservice;
	@PostMapping("/savePopulation/{type}")
	public void save(@RequestBody Population population,@PathVariable int type) {
		populationservice.addPopulation(population,type);
	}
	@GetMapping("/getPopulations")
	public List<Population> getAll() {
		return populationservice.getPopulations();
	}
	@PutMapping("/updatePopulation/{type}")
	public void updateModele(@RequestBody Population population,@PathVariable int type) {
		System.out.println(type);
		populationservice.updatePopulation(population,type);	
	}
	@DeleteMapping("/deletePopulation/{id}")
	public void delete(@PathVariable("id") int id) {
		populationservice.deletePopulation(id);
	}
	@GetMapping("/listSocietes")
	public Set<Population> getSocieties() {
		return populationservice.getSocietes();
	}
	@GetMapping("/listEtablissements")
	public Set<Population> getEtablissements() {
		return populationservice.getEtablissements();
	}
}
