package customers.project.demo.services;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.FrequenceRepository;
import customers.project.demo.dao.ModeleActiviteRepository;
import customers.project.demo.dao.ModeleRepository;
import customers.project.demo.dao.PhaseRepository;
import customers.project.demo.dao.ModeleRepository;
import customers.project.demo.dao.PopulationModeleRepository;
import customers.project.demo.dao.PopulationRepository;
import customers.project.demo.dao.ResponsabiliteModeleRepository;
import customers.project.demo.dao.TypePaieRepository;
import customers.project.demo.dao.TypePopulationRepository;
import customers.project.demo.entities.Frequence;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.ModeleActivite;
import customers.project.demo.entities.Phase;

import customers.project.demo.entities.Population;
import customers.project.demo.entities.PopulationModele;
import customers.project.demo.entities.ResponsabiliteModele;
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
	PopulationModeleRepository populationmodelerepository;
	@Autowired
	ModeleActiviteRepository modeleactiviterepository;
	@Autowired
	ResponsabiliteModeleRepository responsabilitemodelerepository;
	PopulationRepository populationrepository;
	public Modele addModele(Modele modele,int type) {
		modelerepository.save(modele);
		TypePopulation typepopulation=typepoprepository.getOne(type);
		PopulationModele pm=new PopulationModele();
		Date date= new Date();
		pm.setDate_debut(date);
		pm.setModele(modele);
		pm.setTypepopulation(typepopulation);
		pmrepo.save(pm);
		return modelerepository.save(modele);
	}
	
	public List<Modele> getModeles() {
		return modelerepository.selectModeles();
	}
	
	public void updateModele(Modele modele) {
		modelerepository.getOne(modele.getCode_modele()).setModele(modele);
	}
	
	public void deleteModele(long id) {
		Modele modele=modelerepository.getOne(id);
		List<ModeleActivite> listModeleActivities=modeleactiviterepository.findAll();
		List<PopulationModele> listPopulationsModele=populationmodelerepository.findAll();
		List<ResponsabiliteModele> listresponsables=responsabilitemodelerepository.findAll();
		for(int i =0 ;i<listPopulationsModele.size();i++) {
			if(listPopulationsModele.get(i).getModele()==modele) {
				populationmodelerepository.delete(listPopulationsModele.get(i));
			}
		}
		for(int i =0 ;i<listModeleActivities.size();i++) {
			if(listModeleActivities.get(i).getModele()==modele) {
				modeleactiviterepository.delete(listModeleActivities.get(i));
			}
		}
		for(int i =0 ;i<listresponsables.size();i++) {
			if(listresponsables.get(i).getModele()==modele) {
				responsabilitemodelerepository.delete(listresponsables.get(i));
			}
		}
		modelerepository.deleteById(id);
	}
	
	public int compter() {
		return modelerepository.coundAllModeles();
	}
	
	public Set<Population> getPopulations(long Modele) {
		TypePopulation population=populationmodelerepository.selectPopulation(Modele).getPopulation();
		return populationrepository.findPopulations(population.getIdentifiant());
	}
}

