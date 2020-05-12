package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Action;

public interface ActionRepository extends JpaRepository<Action,Long> {
	@Query("FROM Action where date_suppression is null")
	public List<Action> selectActions();
}
