package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.ModeleSuivi;
import customers.project.demo.entities.Suivi;

public interface SuiviRepository  extends JpaRepository<Suivi,String> {
	@Query("SELECT modele FROM Suivi")
	public List<ModeleSuivi> selectModele();
	@Modifying
	@Query("UPDATE Suivi set clotured=?1 WHERE modele.code_modele=?2")
	public void updateSuivi(boolean clotured,long code_modele);
	@Query("FROM Suivi WHERE modele.code_modele=?1")
	public Suivi selectSuivi(long code_modele);
}