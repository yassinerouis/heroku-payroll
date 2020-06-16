package customers.project.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Periode;

public interface PeriodeRepository extends JpaRepository<Periode,Long> {
	@Query("FROM Periode where annee=?1 and mois=?2")
	public Periode getPeriode(int annee,int mois);
}
