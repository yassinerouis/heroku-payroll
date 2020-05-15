package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customers.project.demo.entities.Pays;

public interface PaysRepository extends JpaRepository<Pays,Integer> {
}
