package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import customers.project.demo.entities.Devise;

public interface DeviseRepository extends JpaRepository<Devise,Integer> {
	
}
