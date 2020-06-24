package customers.project.demo.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import customers.project.demo.entities.Documentation;
import customers.project.demo.entities.Famille;
import customers.project.demo.services.DocumentationService;

@RestController
@CrossOrigin
public class DocumentationController {
	public String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads/documents/";
	@Autowired
	DocumentationService documentationservice;
	@PostMapping("/saveDocument")
	public void save(@RequestParam("file") MultipartFile file,@RequestParam("document") String doc) {
		try {
			//Récuperer l'objet documentation
			Documentation documentation = new ObjectMapper().readValue(doc,Documentation.class);
			//Choisir le bon chemin selon le type du document
			if(documentation.getType().equals("CGI")) {
				uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads/documents/CGI";
			}else if(documentation.getType().equals("Code de travail")) {
				uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads/documents/CT";
			}else if(documentation.getType().equals("Convention collective")) {
				uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads/documents/CC";
			}else if(documentation.getType().equals("Paramétrage de la paie")) {
				uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads/documents/PP";
			}
			//Enregistrer le document dans le chemin
			StringBuilder fileNames = new StringBuilder();
			
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			  fileNames.append(file.getOriginalFilename()+" ");
			  Files.write(fileNameAndPath, file.getBytes());
			//Enregistrer le nom du document
			documentation.setFile(file.getOriginalFilename());
			//Ajouter le document dans la base de donnée 
			documentationservice.addDocument(documentation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
	@PutMapping("/updateDocument")
public void updateDocument(@RequestParam(required=false) MultipartFile file,@RequestParam("document") String doc) {
		try {
			Documentation documentation = new ObjectMapper().readValue(doc,Documentation.class);

			if(file==null) {
				int id=new ObjectMapper().readValue(doc,Documentation.class).getIdentifiant();
				documentation.setFile(documentationservice.getDocument(id).getFile());
			}
			else{
				StringBuilder fileNames = new StringBuilder();
				Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
				fileNames.append(file.getOriginalFilename()+" ");
				Files.write(fileNameAndPath, file.getBytes());
			}
			documentationservice.updateDocumentation(documentation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
	@DeleteMapping("/deleteDocument/{id}")
	public void delete(@PathVariable("id") int id) {
		documentationservice.deleteDocumentation(id);
	}
	@GetMapping("/getDocuments")
	public List<Documentation> getAll() {
		return documentationservice.getDocuments();
	}
}
