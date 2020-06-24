package customers.project.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.UtilisateurRepository;
import customers.project.demo.entities.Utilisateur;
@Service
@Transactional
public class UtilisateurService {
		@Autowired
		UtilisateurRepository utilisateurrepository;
		public Utilisateur addutilisateur(Utilisateur utilisateur) {
			return utilisateurrepository.save(utilisateur);
		}
		
		public List<Utilisateur> getutilisateur() {
			return utilisateurrepository.findAll();
		}
		public void updateutilisateur(Utilisateur utilisateur) {
			utilisateurrepository.getOne(utilisateur.getMatricule()).setRole(utilisateur.getRole());
			utilisateurrepository.getOne(utilisateur.getMatricule()).setNom(utilisateur.getNom());
			utilisateurrepository.getOne(utilisateur.getMatricule()).setPrenom(utilisateur.getPrenom());
			utilisateurrepository.getOne(utilisateur.getMatricule()).setEtablissement(utilisateur.getEtablissement());
			utilisateurrepository.getOne(utilisateur.getMatricule()).setSociete(utilisateur.getSociete());
			utilisateurrepository.getOne(utilisateur.getMatricule()).setEmploi(utilisateur.getEmploi());
			utilisateurrepository.getOne(utilisateur.getMatricule()).setStatut(utilisateur.getStatut());
			utilisateurrepository.getOne(utilisateur.getMatricule()).setReglementation(utilisateur.getReglementation());
		}
		public void deleteutilisateur(String id) {
			utilisateurrepository.deleteById(id);
		}
}