package customers.project.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.SousLienRepository;
import customers.project.demo.entities.SousLien;
@Service
@Transactional
public class SousLienService {


	@Autowired
	SousLienRepository sousLienrepository;
	public SousLien addsousLien(SousLien sousLien) {
		return sousLienrepository.save(sousLien);
	}
	public List<SousLien> getsousLien() {
		return sousLienrepository.findAll();
	}
	public void updatesousLien(SousLien sousLien) {
		sousLienrepository.getOne(sousLien.getId()).setLibelle(sousLien.getLibelle());
		sousLienrepository.getOne(sousLien.getId()).setOrdre_affichage(sousLien.getOrdre_affichage());
		sousLienrepository.getOne(sousLien.getId()).setRole(sousLien.getRole());
		sousLienrepository.getOne(sousLien.getId()).setDescription(sousLien.getDescription());
		sousLienrepository.getOne(sousLien.getId()).setLien(sousLien.getLien());
	}
	public void deletesousLien(Integer id) {
		sousLienrepository.deleteById(id);
	}


}