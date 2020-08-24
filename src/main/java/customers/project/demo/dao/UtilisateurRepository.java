package customers.project.demo.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Action;
import customers.project.demo.entities.Population;
import customers.project.demo.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,String> {
	@Query("select role FROM Utilisateur where matricule=?1")
    String selectRole(String matricule);
}
