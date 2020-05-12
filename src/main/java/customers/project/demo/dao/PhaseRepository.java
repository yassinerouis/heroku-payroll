package customers.project.demo.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Phase;

public interface PhaseRepository extends JpaRepository<Phase,Long>{
	@Query("FROM Phase where date_suppression is null")
	public List<Phase> selectPhases();
	
}
