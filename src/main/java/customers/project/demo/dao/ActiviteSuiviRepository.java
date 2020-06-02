package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.ActiviteSuivi;

public interface ActiviteSuiviRepository extends JpaRepository<ActiviteSuivi,Long>  {
	@Query("FROM ActiviteSuivi where phasesuivi.code_phase=?1")
	public List<ActiviteSuivi> getActivities(long phase);
}
