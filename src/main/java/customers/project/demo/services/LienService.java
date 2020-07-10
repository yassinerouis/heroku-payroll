package customers.project.demo.services;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.LienRepository;
import customers.project.demo.dao.SousLienRepository;
import customers.project.demo.entities.Lien;
import customers.project.demo.entities.SousLien;
@Service
@Transactional
public class LienService {
	@Autowired
	LienRepository Lienrepository;
	@Autowired
	SousLienRepository souslienrepository;
	public Lien addLien(Lien Lien) {
		return Lienrepository.save(Lien);
	}
	public Lien getLien(int id) {
		return Lienrepository.getOne(id);
	}
	public List<Lien> getLiensHorizonatl() {
		return Lienrepository.findAllHorizontal();
	}
	public List<SousLien> getSousLiens(int id) {
		return souslienrepository.findAllSousLiens(id);
	}
	public List<Lien> getLiensVertical() {
		for(int i=0;i<Lienrepository.findAllVertical().size();i++) {
			System.out.print(Lienrepository.findAllVertical().get(i).getLibelle());
		}
		return Lienrepository.findAllVertical();
	}
	public void updateLien(Lien Lien) {
		Lienrepository.getOne(Lien.getId()).setLibelle(Lien.getLibelle());
		Lienrepository.getOne(Lien.getId()).setOrdre_affichage(Lien.getOrdre_affichage());
		Lienrepository.getOne(Lien.getId()).setLien(Lien.getLien());
		Lienrepository.getOne(Lien.getId()).setLogo(Lien.getLogo());
		Lienrepository.getOne(Lien.getId()).setRoles(Lien.getRoles());
		
	}
	public void upLien(int id_lien) {
		Lienrepository.up(id_lien);
	}
	public void downLien(int id_lien) {
		Lienrepository.down(id_lien);
	}
	public void deleteLien(Integer id) {
		Lienrepository.deleteById(id);
	}
	
}