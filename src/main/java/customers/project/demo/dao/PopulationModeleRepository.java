package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Phase;
import customers.project.demo.entities.PopulationModele;

public interface PopulationModeleRepository extends JpaRepository<PopulationModele,Long> {
	@Query("FROM PopulationModele where date_fin is null and modele.code_modele=?1")
	public PopulationModele selectPopulation(long modele);
}
