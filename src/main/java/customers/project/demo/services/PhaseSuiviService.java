package customers.project.demo.services;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.ActiviteRepository;
import customers.project.demo.dao.FamilleRepository;
import customers.project.demo.dao.PhaseSuiviRepository;
import customers.project.demo.entities.ActiviteSuivi;
import customers.project.demo.entities.PhaseSuivi;
@Service
@Transactional

public class PhaseSuiviService {
	@Autowired
	PhaseSuiviRepository phasesuivirepository;
	@Autowired
	FamilleRepository famillerepository;
	@Autowired
	ActiviteRepository activiterepository;
public PhaseSuivi addPhaseSuivi(PhaseSuivi phasesuivi) {
		
		return phasesuivirepository.save(phasesuivi);
	}
public List<PhaseSuivi> getPhases(long modele){
	return phasesuivirepository.getPhases(modele);
}
public List<PhaseSuivi> getphasesuivis() {
	return phasesuivirepository.findAll();
}
public Set<ActiviteSuivi> getActivites(long phasesuivi){
	return phasesuivirepository.getOne(phasesuivi).getActivite();
}
public void updatePhaseSuivi(PhaseSuivi phasesuivi) {
	phasesuivirepository.getOne(phasesuivi.getCode_phase()).setPhase(phasesuivi);
}
public void deletephasesuivi(long id) {
	phasesuivirepository.delete(phasesuivirepository.getOne(id));
}
}
