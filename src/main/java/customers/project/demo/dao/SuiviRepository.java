package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customers.project.demo.entities.Suivi;


public interface SuiviRepository  extends JpaRepository<Suivi,String> {

}