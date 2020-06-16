package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import customers.project.demo.entities.MesureComposition;
import customers.project.demo.entities.Modele;

public interface MesureCompositionRepository extends JpaRepository<MesureComposition,Long> {
	@Query("FROM MesureComposition where modele=?1 and annee=?2")
	public List<MesureComposition> filterDashboardComposition(Modele modele,int annee);
	/*@Query("SELECT id,modele,periode.annee,devise,SUM(valeur) FROM Mesure where devise=?1 and modele=?2 and periode.annee=?3 group by libelle")
	public List<Mesure> filterDashboardYear(Devise devise,Modele modele,int annee);*/
}
