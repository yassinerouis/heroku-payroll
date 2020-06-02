package customers.project.demo.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.ActionRepository;
import customers.project.demo.dao.ActionSuiviRepository;
import customers.project.demo.dao.ActiviteRepository;
import customers.project.demo.dao.EspaceTravailRepository;
import customers.project.demo.dao.StatusRepository;
import customers.project.demo.entities.Action;
import customers.project.demo.entities.ActionSuivi;
import customers.project.demo.entities.Activite;
import customers.project.demo.entities.EspaceTravail;
import customers.project.demo.entities.Status;

@Service
@Transactional
public class ActionSuiviService {
@Autowired
ActionSuiviRepository actionsuivirepository;
@Autowired
ActiviteRepository activiterepository;

@Autowired
StatusRepository statusrepository;
public ActionSuivi addActionSuivi(ActionSuivi actionsuivi) {
			return actionsuivirepository.save(actionsuivi);
		}

public List<ActionSuivi> getActions() {
	return actionsuivirepository.findAll();
}
public void updateAction(ActionSuivi actionsuivi) {
	actionsuivirepository.getOne(actionsuivi.getCode()).setAction(actionsuivi);
}

public void deleteAction(long id) {
	actionsuivirepository.deleteById(id);
}

}
