package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Modele;
import customers.project.demo.entities.ResponsabiliteActivite;
import customers.project.demo.entities.ResponsabiliteModele;

public interface ResponsabiliteModeleRepository extends JpaRepository<ResponsabiliteModele,Long>{
	@Query("FROM ResponsabiliteModele where date_fin is null and modele.code_modele=?1")
	public ResponsabiliteModele selectResponsabilite(long modele);
}
