package customers.project.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import customers.project.demo.dao.StatusRepository;
import customers.project.demo.entities.Status;

@Service
@Transactional
public class StatusService {
	@Autowired
	StatusRepository statusrepository;
	public Status addStatus(Status status) {
		return statusrepository.save(status);
	}
	public List<Status> getStatus() {
		return statusrepository.findAll();
	}
	public void updateStatus(Status status) {
		statusrepository.getOne(status.getIdentifiant()).
		setLibelle(status.getLibelle());
		statusrepository.getOne(status.getIdentifiant()).setDescription(status.getDescription());
	}
	public void deleteStatus(Integer id) {
		statusrepository.deleteById(id);
	}
}
