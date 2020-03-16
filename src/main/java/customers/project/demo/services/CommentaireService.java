package customers.project.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.CommentaireRepository;
import customers.project.demo.entities.Commentaire;
@Service
@Transactional
public class CommentaireService {
	@Autowired
	CommentaireRepository commentairerepository;
	public Commentaire addCommentaire(Commentaire commentaire) {
		return commentairerepository.save(commentaire);
	}
	public List<Commentaire> getCommentaire() {
		return commentairerepository.findAll();
	}
	
}
