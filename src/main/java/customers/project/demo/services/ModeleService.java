package customers.project.demo.services;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.FrequenceRepository;
import customers.project.demo.dao.ModelePhaseRepository;
import customers.project.demo.dao.ModeleRepository;
import customers.project.demo.dao.PhaseRepository;
import customers.project.demo.dao.ModeleRepository;
import customers.project.demo.dao.PopulationModeleRepository;
import customers.project.demo.dao.PopulationRepository;
import customers.project.demo.dao.TypePaieRepository;
import customers.project.demo.dao.TypePopulationRepository;
import customers.project.demo.entities.Frequence;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.ModelePhase;
import customers.project.demo.entities.Phase;

import customers.project.demo.entities.Population;
import customers.project.demo.entities.PopulationModele;
import customers.project.demo.entities.TypePaie;
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
	@Autowired
	TypePaieRepository typepaierepository;
	@Autowired
	ModelePhaseRepository modelephaserepository;
	@Autowired
	PhaseRepository phaserepository;
	@Autowired
	PopulationModeleRepository populationmodelerepository;
	@Autowired
	PopulationRepository populationrepository;
	public Modele addModele(Modele modele,int type,int type_paie,int frequence) {
System.out.println(type_paie);
Modele m=modelerepository.save(modele);
	
		
		TypePopulation typepopulation=typepoprepository.getOne(type);
		TypePaie typepaie=typepaierepository.getOne(type_paie);
		Frequence fr=frequencerepository.getOne(frequence);
		PopulationModele pm=new PopulationModele();
		Date date= new Date();
		pm.setDate_debut(date);
		pm.setModele(modele);
		pm.setTypepopulation(typepopulation);
		
		modele.setFrequence(fr);
		modele.setDate_creation(date);
		modele.setTypepaie(typepaie);
		pmrepo.save(pm);
		return modelerepository.save(modele);
	}
	
	public List<Modele> getModeles() {
		return modelerepository.selectModeles();
	}
	
	public void updateModele(Modele modele) {
		
		Date date_modification= new Date();
		modele.setDate_modification(date_modification);
		modelerepository.getOne(modele.getCode_modele()).setModele(modele);
		modelerepository.save(modele);
	}
	
	public void deleteModele(long id) {
		Date date_suppression= new Date();
		modelerepository.getOne(id).setDate_suppression(date_suppression);
	}
	public int compter() {
		System.out.println(modelerepository.coundAllModeles());
		return modelerepository.coundAllModeles();
	}
	public Set<Population> getPopulations(long Modele) {
		TypePopulation population=populationmodelerepository.selectPopulation(Modele).getPopulation();
		return populationrepository.findPopulations(population.getIdentifiant());
	}
}

