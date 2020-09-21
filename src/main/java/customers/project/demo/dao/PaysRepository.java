package customers.project.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Pays;

public interface PaysRepository extends JpaRepository<Pays,Integer> {
	@Query("from Pays where reglementation=?1")
    public Pays findByReglementation(String reglementation);
}
