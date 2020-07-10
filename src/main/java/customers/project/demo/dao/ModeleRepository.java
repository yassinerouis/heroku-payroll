package customers.project.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import customers.project.demo.entities.Modele;

public interface ModeleRepository extends JpaRepository<Modele,Long>{
	@Query("FROM Modele where reglementation=?1")
	public List<Modele> findModeles(String reglementation);
	@Query("FROM Modele where code_modele in ?1")
	public List<Modele> SelectModeles(List<Long> modeles);
	@Query("Select rm.modele FROM ResponsabiliteModele rm where rm.payrollmanager.matricule=?1 and rm.date_fin is null and rm.modele not in ?2")
	public List<Modele> getModeles(String matricule,List<Modele> modeles);
}