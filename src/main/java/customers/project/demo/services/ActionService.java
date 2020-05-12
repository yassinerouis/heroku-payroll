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
	public Action addAction(Action action,int id_status,long id_activite) {
		Activite activite=activiterepository.getOne(id_activite);
		
		Status status=statusrepository.getOne(id_status);
		Date date= new Date();
			action.setStatus(status);
			action.setActivite(activite);
			action.setDate_creation(date);
			return actionrepository.save(action);
		}

public List<Action> getActions() {
	return actionrepository.selectActions();
}
public void updateAction(Action action) {
	Date date_modification= new Date();
	action.setDate_modification(date_modification);

	actionrepository.getOne(action.getCode()).setAction(action);
}

public void deleteAction(long id) {
	Date date_suppression= new Date();
actionrepository.getOne(id).setDate_suppression(date_suppression);
}
}
