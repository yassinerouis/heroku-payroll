package customers.project.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Modele;
import customers.project.demo.entities.Phase;

public interface ModeleRepository extends JpaRepository<Modele,Long>{
	@Query("SELECT count(u) FROM Modele u")
	public int coundAllModeles();
	@Query("FROM Modele where date_suppression is null")
	public List<Modele> selectModeles();
	
}
