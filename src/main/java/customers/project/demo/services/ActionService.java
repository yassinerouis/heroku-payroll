package customers.project.demo.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.ActionRepository;
import customers.project.demo.dao.ActiviteRepository;
import customers.project.demo.dao.EspaceTravailRepository;
import customers.project.demo.dao.StatusRepository;
import customers.project.demo.entities.Action;
import customers.project.demo.entities.Activite;
import customers.project.demo.entities.EspaceTravail;
import customers.project.demo.entities.Status;

@Service
@Transactional
public class ActionService {
@Autowired
ActionRepository actionrepository;
@Autowired
ActiviteRepository activiterepository;

@Autowired
StatusRepository statusrepository;
public Action addAction(Action action) {
	
			return actionrepository.save(action);
		}

public List<Action> getActions() {
	return actionrepository.findAll();
}
public void updateAction(Action action) {
	actionrepository.getOne(action.getCode()).setAction(action);
}

public void deleteAction(long id) {
	actionrepository.deleteById(id);
}
}
