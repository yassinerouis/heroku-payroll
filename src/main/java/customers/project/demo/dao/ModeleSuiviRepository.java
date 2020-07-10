package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.ModeleSuivi;

public interface ModeleSuiviRepository extends JpaRepository<ModeleSuivi,Long> {
	@Query("SELECT MAX(code_modele) FROM ModeleSuivi where modele_principal=?1")
	public long getModele(long modele);
	@Query("FROM ModeleSuivi where modele_principal=?1")
	public List<ModeleSuivi> SelectModeleSuivi(long modele);
	@Query("Select distinct m.modele_principal FROM ModeleSuivi m where m.code_modele in ?1")
	public List<Long> SelectModeles(List<Long> modelessuivi);
}
