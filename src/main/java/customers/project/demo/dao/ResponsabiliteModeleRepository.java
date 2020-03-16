package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customers.project.demo.entities.ResponsabiliteActivite;
import customers.project.demo.entities.ResponsabiliteModele;

public interface ResponsabiliteModeleRepository extends JpaRepository<ResponsabiliteModele,Long>{

}
