package customers.project.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.ModeleActiviteRepository;
import customers.project.demo.dao.ModeleRepository;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.ModeleActivite;

@Service
@Transactional
public class ModeleActiviteService {
	@Autowired
	ModeleActiviteRepository modeleactiviterepository;
	@Autowired
	ModeleRepository modelerepository;
	public void saveModeleActivite(ModeleActivite modeleactivite){
		modeleactiviterepository.save(modeleactivite);
	}
	public void updateModeleActivite(ModeleActivite modeleactivite){
		modeleactiviterepository.getOne(modeleactivite.getId());
	}
	public List<ModeleActivite> selectModeleActivities(Modele modele){
		return modeleactiviterepository.selectActivities(modele.getCode_modele());
	}
	public Modele getModele(long id) {
		return modelerepository.getOne(id);
	}
	
	public List<ModeleActivite> getActivitiesPhases(long phase,long modele){
		return modeleactiviterepository.selectActivitiesPhase(phase,modele);
	}
	public void delete(long id) {
		modeleactiviterepository.deleteById(id);
	}
}
