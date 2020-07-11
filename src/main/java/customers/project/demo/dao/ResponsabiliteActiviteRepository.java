package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Action;
import customers.project.demo.entities.ResponsabiliteActivite;
import customers.project.demo.entities.ResponsabiliteModele;

public interface ResponsabiliteActiviteRepository extends JpaRepository<ResponsabiliteActivite,Long> {
	@Query("FROM ResponsabiliteActivite where date_fin is null and activite.code_activite=?1")
	public List<ResponsabiliteActivite> selectResponsabilites(long activite);
	@Modifying
	@Query("delete FROM ResponsabiliteActivite where activite.code_activite=?1")
	public void deleteResponsabilites(long activite);
}
