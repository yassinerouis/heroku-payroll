package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Lien;
import customers.project.demo.entities.SousLien;

public interface SousLienRepository extends JpaRepository<SousLien,Integer> {
	@Query("FROM SousLien where lien.id=?1 order by ordre_affichage asc")
	public List<SousLien> findAllSousLiens(int id);
}
