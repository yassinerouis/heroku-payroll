package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customers.project.demo.entities.Activite;

public interface ActiviteRepository extends JpaRepository<Activite,String>{

}
