package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Action;
import customers.project.demo.entities.Lien;
import customers.project.demo.entities.Modele;

public interface LienRepository extends JpaRepository<Lien,Integer> {
	@Query("FROM Lien where menu='H'")
	public List<Lien> findAllHorizontal();
	@Query("FROM Lien where menu='V'")
	public List<Lien> findAllVertical();
}
