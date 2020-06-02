package customers.project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import customers.project.demo.entities.Action;
import customers.project.demo.entities.Activite;
import customers.project.demo.entities.Phase;

public interface ActionRepository extends JpaRepository<Action,Long> {
	@Query("FROM Action where activite=?1")
	public List<Action> selectActions(Activite activite);
}
