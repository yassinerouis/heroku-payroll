package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customers.project.demo.entities.PopulationModele;

public interface PopulationModeleRepository extends JpaRepository<PopulationModele,Long> {

}
