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
public Phase addPhase(Phase phase) {
		
		return phaserepository.save(phase);
	}

public List<Phase> getPhases() {
	return phaserepository.selectPhases();
}
public Set<Activite> getActivites(long phase){
	return phaserepository.getOne(phase).getActivite();
}
public void updatePhase(Phase phase) {
	phaserepository.getOne(phase.getCode_phase()).setLibelle(phase.getLibelle());
	phaserepository.getOne(phase.getCode_phase()).setDescription(phase.getDescription());
	phaserepository.getOne(phase.getCode_phase()).setFamille(phase.getFamille());
	phaserepository.getOne(phase.getCode_phase()).setStatus(phase.getStatus());
}
public void deletePhase(long id) {
	phaserepository.delete(phaserepository.getOne(id));
}
}
