package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customers.project.demo.entities.SousLien;

public interface SousLienRepository extends JpaRepository<SousLien,Integer> {

}
