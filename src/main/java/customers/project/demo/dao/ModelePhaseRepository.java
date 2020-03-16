package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customers.project.demo.entities.Action;
import customers.project.demo.entities.ModelePhase;

public interface ModelePhaseRepository extends JpaRepository<ModelePhase,Long> {

}
