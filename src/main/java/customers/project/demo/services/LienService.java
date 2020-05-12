package customers.project.demo.services;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.LienRepository;
import customers.project.demo.entities.Lien;
@Service
@Transactional
public class LienService {


	@Autowired
	LienRepository Lienrepository;
	public Lien addLien(Lien Lien) {
		return Lienrepository.save(Lien);
	}
	public List<Lien> getLien() {
		return Lienrepository.findAll();
	}
	public void updateLien(Lien Lien) {
		Lienrepository.getOne(Lien.getId()).setLibelle(Lien.getLibelle());
		Lienrepository.getOne(Lien.getId()).setOrdre_affichage(Lien.getOrdre_affichage());
		Lienrepository.getOne(Lien.getId()).setLien(Lien.getLien());
		Lienrepository.getOne(Lien.getId()).setSous_lien(Lien.getSous_lien());
		Lienrepository.getOne(Lien.getId()).setDescription(Lien.getDescription());
	}
	public void deleteLien(Integer id) {
		Lienrepository.deleteById(id);
	}
}