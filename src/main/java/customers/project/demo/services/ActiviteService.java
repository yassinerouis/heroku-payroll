package customers.project.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
public Activite addActivite(Activite activite) {
	return activiterepository.save(activite);
	}
public Activite addFirstActivite(Activite activite,int id_status,long id_phase,int id_espacetravail) {
	Phase phase=phaserepository.getOne(id_phase);
	EspaceTravail espacetravail=espacetravailrepository.getOne(id_espacetravail);
		Status status=statusrepository.getOne(id_status);
		Date date= new Date();
		activite.setPhase(phase);
		activite.setStatus(status);
		Activite act=activiterepository.save(activite);
		phase.getActivite().add(activite);
		activite.setEspacetravail(espacetravail);
		return act;
	}

public Activite getActivite(Long id) {
	return activiterepository.getOne(id);
}
public List<Activite> getActivites() {
	return activiterepository.findAll();
}
public Set<Activite> getPrerequis(long id_activite) {
	return activiterepository.getOne(id_activite).getPrerequis();
}
public List<Activite> selectActivites(Long id_phase) {
	Phase phase=phaserepository.getOne(id_phase);
	return activiterepository.selectPhases(phase);
}
public void updateActivite(Activite Activite) {
	activiterepository.getOne(Activite.getCode_activite()).setActivite(Activite);
}
public void deleteActivite(long id) {
	for(int i=0;i<this.getActivites().size();i++) {
		for(int j=0;j<this.getActivites().get(i).getPrerequis().size();j++) {
			List<Activite> list = new ArrayList<Activite>(this.getActivites().get(i).getPrerequis());
			if(list.get(j).getCode_activite()==id) {
				this.getActivites().get(i).getPrerequis().remove(activiterepository.getOne(id));
			}
		}
	}
	activiterepository.getOne(id).setPrecedente(null);
	activiterepository.save(activiterepository.getOne(id));
	activiterepository.deleteById(id);
}

}
