package customers.project.demo.web;

import java.Controllers.Part;
import java.Controllers.SiteImgs;
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
	public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads/documents/";
	@Autowired
	DocumentationService documentationservice;
	@PostMapping("/saveDocument")
	public void save(@RequestParam("file") MultipartFile file,@RequestParam("document") String doc) {
		
		try {
			Documentation documentation = new ObjectMapper().readValue(doc,Documentation.class);
			StringBuilder fileNames = new StringBuilder();
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			  fileNames.append(file.getOriginalFilename()+" ");
			  Files.write(fileNameAndPath, file.getBytes());
			
			documentation.setFile(file.getOriginalFilename());
			documentationservice.addDocument(documentation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
	@PutMapping("/updateDocument")
public void updateDocument(@RequestParam("file") MultipartFile file,@RequestParam("document") String doc) {
		
		try {
			Documentation documentation = new ObjectMapper().readValue(doc,Documentation.class);
			StringBuilder fileNames = new StringBuilder();
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			  fileNames.append(file.getOriginalFilename()+" ");
			  Files.write(fileNameAndPath, file.getBytes());
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