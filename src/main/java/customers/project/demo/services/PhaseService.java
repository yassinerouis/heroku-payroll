package customers.project.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.ActiviteRepository;
import customers.project.demo.dao.FamilleRepository;
import customers.project.demo.dao.PhaseRepository;
import customers.project.demo.entities.Activite;
import customers.project.demo.entities.Famille;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.Phase;
@Service
@Transactional

public class PhaseService {
	@Autowired
	PhaseRepository phaserepository;
	@Autowired
	FamilleRepository famillerepository;
	@Autowired
	ActiviteRepository activiterepository;
public Phase addPhase(Phase phase,int famille) {
		Famille fam=famillerepository.getOne(famille);
		Date date= new Date();
		fam.getPhases().add(phase);
		phase.setDate_creation(date);
		phase.setFamille(fam);
		return phaserepository.save(phase);
	}

public List<Phase> getPhases() {
	return phaserepository.findAll();
}
public Set<Activite> getActivites(Phase phase){
	return phaserepository.getOne(phase.getCode_phase()).getActivite();
}
public void updatePhase(Phase phase) {
	phaserepository.getOne(phase.getCode_phase()).setPhase(phase);
}

public void deleteModele(String id) {
	phaserepository.deleteById(id);
}
}
