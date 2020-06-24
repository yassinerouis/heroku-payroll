package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import customers.project.demo.entities.CompteUtilisateur;

public interface CompteRepository extends JpaRepository<CompteUtilisateur,String> {
	@Query("FROM CompteUtilisateur where username=?1")
	public CompteUtilisateur findByUsername(String username);
}
