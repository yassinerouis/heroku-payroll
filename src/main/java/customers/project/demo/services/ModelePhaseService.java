package customers.project.demo.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.ModelePhaseRepository;
import customers.project.demo.dao.ModeleRepository;
import customers.project.demo.dao.PhaseRepository;
import customers.project.demo.entities.Famille;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.ModelePhase;
import customers.project.demo.entities.Phase;

@Service
@Transactional
public class ModelePhaseService {
	@Autowired
	ModeleRepository modelerepository;
	@Autowired 
	PhaseRepository phaserepository;
	@Autowired
	ModelePhaseRepository modelephaserepository;
	
	public ModelePhase addModelePhase(String phase,String modele) {
		Phase pha=phaserepository.getOne(phase);
		Modele mod=modelerepository.getOne(modele);
		ModelePhase modelephase=new ModelePhase();
		modelephase.setPhase(pha);
		modelephase.setModele(mod);
		modelephaserepository.save(modelephase);
		
		pha.getModele().add(modelephase);
		mod.getPhase().add(modelephase);
		
		return modelephaserepository.save(modelephase);
	}
	public List<ModelePhase> getModelePhases() {
		return modelephaserepository.findAll();
	}
	
	public void updateModele(ModelePhase modelephase) {
		Modele modele=modelerepository.getOne(modelephase.getModele().getCode_modele());
		Phase phase=phaserepository.getOne(modelephase.getPhase().getCode_phase());
		modelephaserepository.getOne(modelephase.getId()).setModele(modele);
		modelephaserepository.getOne(modelephase.getId()).setPhase(phase);
	}
	
	public void deleteModele(Long id) {
		modelephaserepository.deleteById(id);
	}
}
