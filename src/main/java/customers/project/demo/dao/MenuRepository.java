package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customers.project.demo.entities.Action;
import customers.project.demo.entities.Menu;

public interface MenuRepository extends JpaRepository<Menu,Integer> {

}
