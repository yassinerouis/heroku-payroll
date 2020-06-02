package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.ModeleActivite;
import customers.project.demo.entities.ModeleSuivi;
import customers.project.demo.entities.Suivi;

public interface SuiviRepository  extends JpaRepository<Suivi,String> {
	@Query("SELECT modele FROM Suivi")
	public List<ModeleSuivi> selectModele();
	
}