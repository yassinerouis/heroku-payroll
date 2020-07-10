package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.ActiviteSuivi;
import customers.project.demo.entities.ModeleSuivi;
import customers.project.demo.entities.PhaseSuivi;

public interface ActiviteSuiviRepository extends JpaRepository<ActiviteSuivi,Long>  {
	@Query("FROM ActiviteSuivi where phasesuivi.code_phase=?1 order by ordre_affichage asc")
	public List<ActiviteSuivi> getActivities(long phase);
	@Query("Select distinct a.phasesuivi FROM ActiviteSuivi a where a.responsable.matricule=?1")
	public List<PhaseSuivi> SelectPhasesSuivi(String matricule);
}
