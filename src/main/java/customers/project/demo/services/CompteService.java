package customers.project.demo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.CompteRepository;
import customers.project.demo.dao.RoleRepository;
import customers.project.demo.dao.UtilisateurRepository;
import customers.project.demo.entities.CompteUtilisateur;
import customers.project.demo.entities.Role;
import customers.project.demo.entities.Utilisateur;

@Service
@Transactional
public class CompteService {
	 @Autowired
	 RoleRepository rolerepository;
	 @Autowired
	 UtilisateurRepository userrepository;
@Autowired
CompteRepository compterepository;
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;
public CompteUtilisateur save(CompteUtilisateur compte) {
	compte.setPassword(bCryptPasswordEncoder.encode(compte.getPassword()));
	Role role=rolerepository.selectRole(userrepository.selectRole(compte.getUtilisateur().getMatricule()));
	compte.setRole(role);
	return compterepository.save(compte);
}
public Utilisateur findUser(String username) {
	return compterepository.findByUsername(username).getUtilisateur();
}

public CompteUtilisateur findUserByUserNamme(String username) {
	return compterepository.findByUsername(username);
}
}
