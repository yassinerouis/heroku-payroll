package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customers.project.demo.entities.Modele;
import customers.project.demo.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{

}