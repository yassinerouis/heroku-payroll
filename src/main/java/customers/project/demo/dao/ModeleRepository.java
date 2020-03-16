package customers.project.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Modele;

public interface ModeleRepository extends JpaRepository<Modele,String>{
	@Query("SELECT count(u) FROM Modele u")
	public int coundAllModeles();
	
}
