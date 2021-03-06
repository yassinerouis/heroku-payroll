package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.ModeleSuivi;
import customers.project.demo.entities.PhaseSuivi;

public interface PhaseSuiviRepository extends JpaRepository<PhaseSuivi,Long> {
	@Query("FROM PhaseSuivi where modelesuivi.code_modele=?1")
	public List<PhaseSuivi> getPhases(long modele);
	@Query("Select distinct p.modelesuivi FROM PhaseSuivi p where p.code_phase in ?1")
	public List<ModeleSuivi> SelectModelesSuivi(List<Long> phases);
}
