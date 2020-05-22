package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Activite;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.ModeleActivite;

public interface ModeleActiviteRepository extends JpaRepository<ModeleActivite,Long>{
	@Query("FROM ModeleActivite where modele.code_modele=?1")
	public List<ModeleActivite> selectActivities(long code_modele);
}
