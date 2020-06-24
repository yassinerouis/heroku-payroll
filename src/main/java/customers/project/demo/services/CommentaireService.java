package customers.project.demo.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
		LocalDateTime myDateObj = LocalDateTime.now();  
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss");  
		String formattedDate = myDateObj.format(myFormatObj);  
		commentaire.setDate_commentaire(formattedDate);
		commentaire.setFichiers(null);
		return commentairerepository.save(commentaire);
	}
	public List<Commentaire> getCommentaire(long id_activite) {
		for(int i=0;i<commentairerepository.getComments(id_activite).size();i++) {
			System.out.println(commentairerepository.getComments(id_activite).get(i).getContenu());
		}
		return commentairerepository.getComments(id_activite);
	}
	public void setComment(long id,List<String> fichiers) {
		 commentairerepository.getOne(id).setFichiers(fichiers);
	}
	public void deleteComment(long id) {
		commentairerepository.deleteById(id);
	}
}
