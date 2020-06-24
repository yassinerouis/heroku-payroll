package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Action;
import customers.project.demo.entities.Commentaire;
import customers.project.demo.entities.CompteUtilisateur;

public interface CommentaireRepository extends JpaRepository<Commentaire,Long> {
	@Query("FROM Commentaire where activite.code_activite=?1")
	public List<Commentaire> getComments(long activite);
}
