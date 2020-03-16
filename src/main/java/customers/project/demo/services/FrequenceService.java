package customers.project.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.FrequenceRepository;
import customers.project.demo.entities.Frequence;
@Service
@Transactional
public class FrequenceService {
	@Autowired
		FrequenceRepository Frequencerepository;
		public Frequence addFrequence(Frequence Frequence) {
			return Frequencerepository.save(Frequence);
		}
		public List<Frequence> getFrequence() {
			return Frequencerepository.findAll();
		}
		public void updateFrequence(Frequence Frequence) {
			Frequencerepository.getOne(Frequence.getIdentifiant()).
			setLibelle(Frequence.getLibelle());
			Frequencerepository.getOne(Frequence.getIdentifiant()).setDescription(Frequence.getDescription());
		}
		public void deleteFrequence(Integer id) {
			Frequencerepository.deleteById(id);
		}
}
