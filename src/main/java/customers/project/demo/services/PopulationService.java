package customers.project.demo.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.ModeleRepository;
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
		@Autowired
		ModeleRepository modelerepository;
		public Population addPopulation(Population population,int type) {
			TypePopulation typepop=typepopulationrepository.getOne(type);
			population.setTypepopulation(typepop);
			return populationrepository.save(population);
		}
		public List<Population> findSocieties(int reglementation){
			return populationrepository.getSocietes(reglementation);
		}
		public List<Population> getReglementations(){
			return populationrepository.getReglementations();
		}
		public List<Population> findPopulations(long modele) {
			String reglementation=modelerepository.getOne(modele).getReglementation();
			List<Population> populations=new ArrayList<Population>();
			String typepopulation=modelerepository.getOne(modele).getTypepopulation().getLibelle();
			if(typepopulation.equals("Réglementation")) {
				populations=populationrepository.getReglementation(reglementation);
			}else if(typepopulation.equals("Société")||typepopulation.equals("Site")) {
				populations=populationrepository.getSocieteOrSite(reglementation);
			}else if(typepopulation.equals("Etablissement")) {
				System.out.println("Etablissement"+populationrepository.getSocietesReglementation(reglementation).size());
				populations=populationrepository.getEtablissementSociete(populationrepository.getSocietesReglementation(reglementation));
			}
			return populations;
		}
		public Population getPopulation(int id) {
			return populationrepository.getOne(id);
		}
		public List<Population> getPopulations() {
			return populationrepository.findAll();
		}
		public void updatePopulation(Population population,int type) {
			TypePopulation typepop=typepopulationrepository.getOne(type);
			population.setTypepopulation(typepop);
			populationrepository.getOne(population.getIdentifiant()).setLibelle(population.getLibelle());
			System.out.println("code"+population.getCode());
			populationrepository.getOne(population.getIdentifiant()).setCode(population.getCode());
			populationrepository.save(population);
		}
		public void updatepopulation(Population population,int type) {
			TypePopulation typepop=typepopulationrepository.getOne(type);
			population.setTypepopulation(typepop);
			populationrepository.getOne(population.getIdentifiant()).setLibelle(population.getLibelle());
			populationrepository.getOne(population.getIdentifiant()).setCode(population.getCode());
			populationrepository.getOne(population.getIdentifiant()).setPopulation(population.getPopulation());

			populationrepository.save(population);
		}
		public void deletePopulation(int id) {
			populationrepository.deleteById(id);
		}
		public Set<Population> getEtablissements() {
			return populationrepository.PopulationsEtablissement();
		}
		public Set<Population> getSocietes() {
			return populationrepository.PopulationsSociete();
		}

}
