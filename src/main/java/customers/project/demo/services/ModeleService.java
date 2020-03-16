package customers.project.demo.services;

import java.util.Date;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.FrequenceRepository;
import customers.project.demo.dao.ModeleRepository;
import customers.project.demo.dao.ModeleRepository;
import customers.project.demo.dao.PopulationModeleRepository;
import customers.project.demo.dao.PopulationRepository;
import customers.project.demo.dao.TypePopulationRepository;
import customers.project.demo.entities.Frequence;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.Population;
import customers.project.demo.entities.PopulationModele;
import customers.project.demo.entities.TypePopulation;


@Service
@Transactional

public class ModeleService {
	@Autowired
	TypePopulationRepository typepoprepository;
	@Autowired
	ModeleRepository modelerepository;
	@Autowired
	PopulationModeleRepository pmrepo;
	@Autowired
	FrequenceRepository frequencerepository;
	/*public Modele test() {
		Population p=new Population();
		p.setCode_population("P01");
		p.setLibelle("xx");
		p.setType("yy");
		Modele m=new Modele("m1","x","y","z",10);
		p.getModeles().add(m);
		poprepository.save(p);
		m.getPopulations().add(p);
		
		modelerepository.save(m);
		return m;
		
	}*/
	
	public Modele addModele(Modele modele,String type,int frequence) {
		System.out.println("hhhhhhhhh");
		//Set<Population> populations=new HashSet<Population>();
		/* Population population=new Population();
		population=poprepository.getOne("P01");
		population.getModeles().add(modele);
		//populations.add(population);
		modele.getPopulations().add(population);
		poprepository.save(population); */
		//return modelerepository.save(modele);
		Modele m=modelerepository.save(modele);
		TypePopulation typepopulation=typepoprepository.getOne(type);
		Frequence fr=frequencerepository.getOne(frequence);
		PopulationModele pm=new PopulationModele();
		Date date= new Date();
		pm.setDate_debut(date);
		pm.setModele(modele);
		pm.setTypepopulation(typepopulation);
		
		typepopulation.getModele().add(pm);
		modele.setFrequence(fr);
		modele.getPopulations().add(pm);
		modele.setDate_creation(date);
		
		pmrepo.save(pm);
		return modelerepository.save(modele);
	}
	
	public List<Modele> getModeles() {
		return modelerepository.findAll();
	}
	
	public void updateModele(Modele modele) {
		modelerepository.getOne(modele.getCode_modele()).setModele(modele);
	}
	
	public void deleteModele(String id) {
		modelerepository.deleteById(id);
	}
	public int compter() {
		System.out.println(modelerepository.coundAllModeles());
		return modelerepository.coundAllModeles();
	}	
}

