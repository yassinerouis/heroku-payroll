package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import customers.project.demo.entities.Activite;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.ModeleActivite;
import customers.project.demo.entities.Phase;

public interface ModeleActiviteRepository extends JpaRepository<ModeleActivite,Long>{
	@Query("FROM ModeleActivite where modele.code_modele=?1")
	public List<ModeleActivite> selectActivities(long code_modele);
	@Query("FROM ModeleActivite where phase.code_phase=?1 and modele.code_modele=?2")
	public List<ModeleActivite> selectActivitiesPhase(long code_phase,long code_modele);
	@Query("FROM ModeleActivite")
	public List<ModeleActivite> selectModelesActivitie();
}
