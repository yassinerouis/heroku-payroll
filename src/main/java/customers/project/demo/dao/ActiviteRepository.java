package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Activite;
import customers.project.demo.entities.Phase;

public interface ActiviteRepository extends JpaRepository<Activite,Long>{
	@Query("FROM Activite where phase=?1")
	public List<Activite> selectPhases(Phase phase);
	@Query("FROM Activite where date_suppression is null")
	public List<Activite> selectActivities();
}
