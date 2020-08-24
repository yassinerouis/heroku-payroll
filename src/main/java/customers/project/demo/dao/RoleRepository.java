package customers.project.demo.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Modele;
import customers.project.demo.entities.Population;
import customers.project.demo.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{
	@Query("FROM Role where name=?1")
    Role selectRole(String role);
}
