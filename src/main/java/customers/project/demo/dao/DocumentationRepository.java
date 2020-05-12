package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customers.project.demo.entities.Documentation;

public interface DocumentationRepository extends JpaRepository<Documentation,Integer>  {

}
