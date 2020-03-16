package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import customers.project.demo.entities.Phase;

public interface PhaseRepository extends JpaRepository<Phase,String>{

}
