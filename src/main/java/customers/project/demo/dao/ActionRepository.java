package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customers.project.demo.entities.Action;

public interface ActionRepository extends JpaRepository<Action,String> {

}
