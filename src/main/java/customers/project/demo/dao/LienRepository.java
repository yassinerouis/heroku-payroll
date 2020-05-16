package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Action;
import customers.project.demo.entities.Lien;
import customers.project.demo.entities.Modele;

public interface LienRepository extends JpaRepository<Lien,Integer> {
	@Query("FROM Lien where menu='H' order by ordre_affichage asc")
	public List<Lien> findAllHorizontal();
	@Query("FROM Lien where menu='V' order by ordre_affichage asc")
	public List<Lien> findAllVertical();
}
