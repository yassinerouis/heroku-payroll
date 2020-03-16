package customers.project.demo.services;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.PopulationRepository;
import customers.project.demo.dao.TypePopulationRepository;
import customers.project.demo.entities.Population;
import customers.project.demo.entities.TypePopulation;

@Service
@Transactional

public class PopulationService {
	
		@Autowired
		PopulationRepository populationrepository;
		@Autowired
		TypePopulationRepository typepopulationrepository;
		public Population addPopulation(Population population,String type) {
			TypePopulation typepop=typepopulationrepository.getOne(type);
			population.setTypepopulation(typepop);
			return populationrepository.save(population);
		}
		
		public List<Population> getPopulations() {
			return populationrepository.findAll();
		}
		public void updatePopulation(Population population,String type) {
			TypePopulation typepop=typepopulationrepository.getOne(type);
			population.setTypepopulation(typepop);
			populationrepository.getOne(population.getCode_population()).setLibelle(population.getLibelle());
		}
		public void deletePopulation(String id) {
			populationrepository.deleteById(id);
		}
		
		
		
}