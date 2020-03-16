package customers.project.demo.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.ActiviteRepository;
import customers.project.demo.dao.PhaseRepository;
import customers.project.demo.dao.StatusRepository;
import customers.project.demo.dao.ActiviteRepository;
import customers.project.demo.entities.Activite;
import customers.project.demo.entities.Phase;
import customers.project.demo.entities.Status;

@Service
@Transactional

public class ActiviteService {
	@Autowired
	ActiviteRepository activiterepository;
	@Autowired
	StatusRepository statusrepository;
	@Autowired
	PhaseRepository phaserepository;
public Activite addActivite(Activite activite,int id_status,String id_phase,String id_prerequis) {
	Phase phase=phaserepository.getOne(id_phase);
		Status status=statusrepository.getOne(id_status);
		Date date= new Date();
		activite.setPhase(phase);
		activite.setDate_creation(date);
		activite.setStatus(status);
		Activite prerequis=activiterepository.getOne(id_prerequis);
			activite.setPrecedente(prerequis);
			Activite act=activiterepository.save(activite);
		status.getActivite().add(activite);
		return act;
	}
public Activite addFirstActivite(Activite activite,int id_status,String id_phase) {
	Phase phase=phaserepository.getOne(id_phase);
		Status status=statusrepository.getOne(id_status);
		Date date= new Date();
		activite.setPhase(phase);
		activite.setDate_creation(date);
		activite.setStatus(status);
		activite.setPrecedente(activite);
		Activite act=activiterepository.save(activite);
		phase.getActivite().add(activite);
		status.getActivite().add(activite);
		return act;
	}

public List<Activite> getActivites() {
	return activiterepository.findAll();
}
public void updateActivite(Activite Activite) {
	activiterepository.getOne(Activite.getCode_activite()).setActivite(Activite);
}

public void deleteActivite(String id) {
	activiterepository.deleteById(id);
}

}
