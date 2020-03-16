package  customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customers.project.demo.entities.Population;


public interface PopulationRepository extends JpaRepository<Population, String> {
	
}
