package customers.project.demo.services;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
		return commentairerepository.save(commentaire);
	}
	public List<Commentaire> getCommentaire() {
		return commentairerepository.findAll();
	}
	
	
}
