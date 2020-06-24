package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Devise;

public interface DeviseRepository extends JpaRepository<Devise,Integer> {
	@Query("FROM Devise where pays.code=?1")
	public Devise getDevise(int pays);
}
