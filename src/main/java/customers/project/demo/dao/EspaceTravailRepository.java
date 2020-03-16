package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customers.project.demo.entities.Action;
import customers.project.demo.entities.EspaceTravail;

public interface EspaceTravailRepository extends JpaRepository<EspaceTravail,Integer> {

}
