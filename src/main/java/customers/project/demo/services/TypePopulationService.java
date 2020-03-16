package customers.project.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.TypePopulationRepository;
import customers.project.demo.entities.TypePopulation;
@Service
@Transactional
public class TypePopulationService {

	@Autowired
	TypePopulationRepository typepoprepository;
	
	public TypePopulation addTypePopulation(TypePopulation typepopulation) {
		System.out.println("hello");
		return typepoprepository.save(typepopulation);
	}
	public List<TypePopulation> getTypePopulations() {
		return typepoprepository.findAll();
	}
	public void updateTypePopulation(TypePopulation typepopulation) {
		typepoprepository.getOne(typepopulation.getType_population()).
		setLibelle(typepopulation.getLibelle());
	}
	public void deleteTypePopulation(String id) {
		typepoprepository.deleteById(id);
	}
}
