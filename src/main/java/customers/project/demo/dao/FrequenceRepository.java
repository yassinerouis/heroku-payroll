package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customers.project.demo.entities.Action;
import customers.project.demo.entities.Frequence;

public interface FrequenceRepository extends JpaRepository<Frequence,Integer> {

}
