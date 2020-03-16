package customers.project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customers.project.demo.entities.Status;



public interface StatusRepository  extends JpaRepository<Status,Integer> {

}
