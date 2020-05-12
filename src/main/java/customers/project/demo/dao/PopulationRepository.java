package  customers.project.demo.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Population;


public interface PopulationRepository extends JpaRepository<Population, Integer> {
	@Query("select identifiant,libelle,typepopulation from Population")
    Set<Population> findAllPopulations();
	@Query("from Population where typepopulation.identifiant=?1")
    Set<Population> findPopulations(int type);
}
