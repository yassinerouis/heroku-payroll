package customers.project.demo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.CompteRepository;
import customers.project.demo.entities.CompteUtilisateur;
import customers.project.demo.entities.Utilisateur;

@Service
@Transactional
public class CompteService {
@Autowired
CompteRepository compterepository;
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;
public CompteUtilisateur save(CompteUtilisateur compte) {
	compte.setPassword(bCryptPasswordEncoder.encode(compte.getPassword()));
	return compterepository.save(compte);
}
public Utilisateur findUser(String username) {
	return compterepository.findByUsername(username).getUtilisateur();
}
public CompteUtilisateur findUserByUserNamme(String username) {
	return compterepository.findByUsername(username);
}
}
