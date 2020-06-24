package customers.project.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import customers.project.demo.entities.Modele;

public interface ModeleRepository extends JpaRepository<Modele,Long>{
	@Query("FROM Modele where reglementation=?1")
	public List<Modele> findModeles(String reglementation);
}
