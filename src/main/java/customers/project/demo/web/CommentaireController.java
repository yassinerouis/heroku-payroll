package customers.project.demo.web;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import customers.project.demo.entities.Commentaire;
import customers.project.demo.entities.Famille;
import customers.project.demo.entities.Lien;
import customers.project.demo.services.CommentaireService;
@RestController
@CrossOrigin
public class CommentaireController {
	public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads/comments";

	@Autowired
	CommentaireService commentaireservice;
	@PostMapping("/savecommentaire")
	public Commentaire save(@RequestBody Commentaire comment) {
		System.out.println(comment.getActivite().getCode_activite()+"-"+comment.getUtilisateur().getMatricule()+"-"+comment.getContenu());
		return commentaireservice.addCommentaire(comment);
	}
	@PostMapping("/saveFichiersCommentaire/{id_commentaire}")
	
	public void save(@RequestParam("fichiers") List<MultipartFile> files,@PathVariable long id_commentaire) {
		try {
			StringBuilder fileNames = new StringBuilder();
			List<String> filelist=new ArrayList<String>();
			for(int i=0;i<files.size();i++) {
				Path fileNameAndPath = Paths.get(uploadDirectory, files.get(i).getOriginalFilename());
				fileNames.append(files.get(i).getOriginalFilename()+" ");
				Files.write(fileNameAndPath, files.get(i).getBytes());
				filelist.add(files.get(i).getOriginalFilename());
				
			}
			commentaireservice.setComment(id_commentaire,filelist);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@GetMapping("/getCommentaires/{id_activite}")
	public List<Commentaire> getComments(@PathVariable long id_activite) {
		try {
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(commentaireservice.getCommentaire(id_activite)!=null)
		return commentaireservice.getCommentaire(id_activite);
		else 
			return null;
	}
	@DeleteMapping("/deleteComment/{id}")
	public void deleteComment(@PathVariable long id) {
		commentaireservice.deleteComment(id);
	}
}