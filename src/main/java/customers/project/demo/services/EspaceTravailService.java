package customers.project.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.EspaceTravailRepository;
import customers.project.demo.entities.EspaceTravail;

	@Service
	@Transactional
	public class EspaceTravailService {
		@Autowired
		EspaceTravailRepository EspaceTravailrepository;
		public EspaceTravail addEspaceTravail(EspaceTravail EspaceTravail) {
			return EspaceTravailrepository.save(EspaceTravail);
		}
		public List<EspaceTravail> getEspaceTravail() {
			return EspaceTravailrepository.findAll();
		}
		public void updateEspaceTravail(EspaceTravail EspaceTravail) {
			EspaceTravailrepository.getOne(EspaceTravail.getId()).
			setLibelle(EspaceTravail.getLibelle());
			EspaceTravailrepository.getOne(EspaceTravail.getId()).setDescription(EspaceTravail.getDescription());
		}
		public void deleteEspaceTravail(Integer id) {
			EspaceTravailrepository.deleteById(id);
		}
	}
