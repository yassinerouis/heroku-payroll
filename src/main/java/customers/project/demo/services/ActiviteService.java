package customers.project.demo.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.ActiviteRepository;
import customers.project.demo.dao.EspaceTravailRepository;
import customers.project.demo.dao.PhaseRepository;
import customers.project.demo.dao.StatusRepository;
import customers.project.demo.dao.ActiviteRepository;
import customers.project.demo.entities.Activite;
import customers.project.demo.entities.EspaceTravail;
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
	EspaceTravailRepository espacetravailrepository;
	@Autowired
	
	
	PhaseRepository phaserepository;
public Activite addActivite(Activite activite,int id_status,long id_phase,long id_prerequis,int id_espacetravail) {
	Phase phase=phaserepository.getOne(id_phase);
		Status status=statusrepository.getOne(id_status);
		EspaceTravail espacetravail=espacetravailrepository.getOne(id_espacetravail);

		Date date= new Date();
		activite.setPhase(phase);
		activite.setDate_creation(date);
		activite.setStatus(status);
		activite.setEspacetravail(espacetravail);
		Activite prerequis=activiterepository.getOne(id_prerequis);
			activite.setPrecedente(prerequis);
			Activite act=activiterepository.save(activite);
		
		return act;
	}
public Activite addFirstActivite(Activite activite,int id_status,long id_phase,int id_espacetravail) {
	Phase phase=phaserepository.getOne(id_phase);
	EspaceTravail espacetravail=espacetravailrepository.getOne(id_espacetravail);
		Status status=statusrepository.getOne(id_status);
		Date date= new Date();
		activite.setPhase(phase);
		activite.setDate_creation(date);
		activite.setStatus(status);
		activite.setPrecedente(activite);
		Activite act=activiterepository.save(activite);
		phase.getActivite().add(activite);
		activite.setEspacetravail(espacetravail);
		return act;
	}

public List<Activite> getActivites() {
	return activiterepository.selectActivities();
}
public List<Activite> selectActivites(Long id_phase) {
	Phase phase=phaserepository.getOne(id_phase);
	return activiterepository.selectPhases(phase);
}
public void updateActivite(Activite Activite) {
	Date date_modification= new Date();
	Activite.setDate_modification(date_modification);
	activiterepository.getOne(Activite.getCode_activite()).setActivite(Activite);
	
}

public void deleteActivite(long id) {
	Date date_suppression= new Date();
activiterepository.getOne(id).setDate_suppression(date_suppression);
}

}
