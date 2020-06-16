package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import customers.project.demo.entities.MesureGraphe;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.Periode;

public interface MesureGrapheRepository extends JpaRepository<MesureGraphe,Long> {
	@Query("FROM MesureGraphe where modele=?1 and periode=?2")
	public List<MesureGraphe> filterDashboardGraphe(Modele modele,Periode periode);
	/*@Query("SELECT id,modele,periode.annee,devise,SUM(valeur) FROM Mesure where devise=?1 and modele=?2 and periode.annee=?3 group by libelle")
	public List<Mesure> filterDashboardYear(Devise devise,Modele modele,int annee);*/
}
