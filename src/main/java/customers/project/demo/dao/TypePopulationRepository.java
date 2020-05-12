package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customers.project.demo.entities.TypePopulation;

public interface TypePopulationRepository  extends JpaRepository<TypePopulation,Integer>{

}
