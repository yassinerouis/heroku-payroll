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

import customers.project.demo.entities.TypePopulation;
import customers.project.demo.services.TypePopulationService;

@RestController
@CrossOrigin

public class TypePopulationController {
	@Autowired
	TypePopulationService typepopulationservice;
	@PostMapping("/savetypepopulation")
	public void save(@RequestBody TypePopulation typepopulation) {
		typepopulationservice.addTypePopulation(typepopulation);
	}
	@GetMapping("/gettypepopulations")
	public List<TypePopulation> getAll() {
		return typepopulationservice.getTypePopulations();
	}
	@PutMapping("/updatetypepopulation")
	public void updateModele(@RequestBody TypePopulation typepopulation) {
		typepopulationservice.updateTypePopulation(typepopulation);
	}
	@DeleteMapping("/deletetypepopulation/{id}")
	public void delete(@PathVariable("id") int id) {
		typepopulationservice.deleteTypePopulation(id);
	}
}
