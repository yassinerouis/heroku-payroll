package customers.project.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import customers.project.demo.entities.Commentaire;
import customers.project.demo.entities.Famille;
import customers.project.demo.services.CommentaireService;
@RestController
@CrossOrigin
public class CommentaireController {
	@Autowired
	CommentaireService commentaireservice;
	@PostMapping("/savecommentaire")
	public void save(@RequestBody Commentaire commentaire) {
		commentaireservice.addCommentaire(commentaire);
	}
	@GetMapping("/getCommentaires")
	public List<Commentaire> getAll() {
		return commentaireservice.getCommentaire();
	}
}