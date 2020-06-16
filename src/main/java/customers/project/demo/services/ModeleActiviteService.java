package customers.project.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.ActiviteRepository;
import customers.project.demo.dao.ModeleActiviteRepository;
import customers.project.demo.dao.ModeleRepository;
import customers.project.demo.entities.Activite;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.ModeleActivite;
import customers.project.demo.entities.Phase;

@Service
@Transactional
public class ModeleActiviteService {
	@Autowired
	ModeleActiviteRepository modeleactiviterepository;
	@Autowired
	ModeleRepository modelerepository;
	@Autowired
	ActiviteRepository activiterepository;
	public void saveModeleActivite(ModeleActivite modeleactivite){
		modeleactiviterepository.save(modeleactivite);
	}
	public void updateModeleActivite(ModeleActivite modeleactivite){
		modeleactiviterepository.getOne(modeleactivite.getId());
	}
	public List<Modele> getModeles(long id){
		List<ModeleActivite> modelesactivite= modeleactiviterepository.selectModelesActivitie();
		List<Modele> modeles=new ArrayList<Modele>();
		for(int i=0;i<modelesactivite.size();i++) {
			if(modelesactivite.get(i).getActivite().getCode_activite()==id) {
				modeles.add(modelesactivite.get(i).getModele());
			}
		}
		return modeles;
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
	public List<Activite> getActivities(long id_modele){
		Modele modele=this.getModele(id_modele);
		List<Activite> listActivities=new ArrayList<Activite>();
		for(int i=0;i<this.selectModeleActivities(modele).size();i++) {
			listActivities.add(this.selectModeleActivities(modele).get(i).getActivite());
		}
		return listActivities;
	}
	public List<Long> getPhases(long id_modele){
		Modele modele=this.getModele(id_modele);
		List<Activite> listActivities=this.getActivities(modele.getCode_modele());
		
		List<Long> listPhases=new ArrayList<Long>();
		for(int i=0;i<listActivities.size();i++) {
			if(listPhases.size()==0) {
				listPhases.add(listActivities.get(i).getPhase().getCode_phase());
			}
			else {
				int non=0;
				for(int j=0;j<listPhases.size();j++) {
					if(listPhases.get(j)!=listActivities.get(i).getPhase().getCode_phase()) {
						non++;
					}
				}
				if(non==listPhases.size()) {
					listPhases.add(listActivities.get(i).getPhase().getCode_phase());
				}
			}		
		}
		return listPhases;
	}
	public List<Phase> getObjectPhases(long id_modele){
		Modele modele=this.getModele(id_modele);
		List<Activite> listActivities=this.getActivities(modele.getCode_modele());
		List<Phase> listPhases=new ArrayList<Phase>();
		for(int i=0;i<listActivities.size();i++) {
			if(listPhases.size()==0) {
				listPhases.add(listActivities.get(i).getPhase());
			}
			else {
				int non=0;
				for(int j=0;j<listPhases.size();j++) {
					if(listPhases.get(j).getCode_phase()!=listActivities.get(i).getPhase().getCode_phase()) {
						non++;
					}
				}
				if(non==listPhases.size()) {
					listPhases.add(listActivities.get(i).getPhase());
				}
			}		
		}
		return listPhases;
	}
}
