package  customers.project.demo.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Population;
import customers.project.demo.entities.TypePopulation;


public interface PopulationRepository extends JpaRepository<Population, Integer> {
	@Query("select identifiant,libelle,typepopulation from Population")
    Set<Population> findAllPopulations();
	@Query("from Population where typepopulation.identifiant=?1")
    Set<Population> findPopulations(int type);
	@Query("from Population where typepopulation.identifiant in (select identifiant from TypePopulation where libelle='etablissement' or libelle='Etablissement' or libelle='établissement') ")
	Set<Population> PopulationsEtablissement();
	@Query("select p from Population p,TypePopulation tp where p.typepopulation.identifiant in (select tp.identifiant from TypePopulation tp where tp.libelle='Societe' or tp.libelle='societe' or tp.libelle='Société' or tp.libelle='société'  ) ")
	Set<Population> PopulationsSociete();
}
