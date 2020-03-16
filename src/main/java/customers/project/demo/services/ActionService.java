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
EspaceTravailRepository espacetravailrepository;
@Autowired
StatusRepository statusrepository;
	public Action addAction(Action action,int id_status,String id_activite,int id_espace_travail) {
		Activite activite=activiterepository.getOne(id_activite);
		EspaceTravail espacetravail=espacetravailrepository.getOne(id_espace_travail);
		Status status=statusrepository.getOne(id_status);
		Date date= new Date();
			action.setStatus(status);
			action.setActivite(activite);
			action.setEspacetravail(espacetravail);
			action.setDate_creation(date);
			Action act=actionrepository.save(action);
			status.getAction().add(action);
			activite.getActions().add(action);
			espacetravail.getActions().add(action);
			return act;
		}

public List<Action> getActions() {
	return actionrepository.findAll();
}
public void updateAction(Action action) {
	actionrepository.getOne(action.getCode()).setAction(action);
}

public void deleteAction(String id) {
	actionrepository.deleteById(id);
}
}
