package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customers.project.demo.entities.Famille;

public interface FamilleRepository extends JpaRepository<Famille, Integer> {
}
