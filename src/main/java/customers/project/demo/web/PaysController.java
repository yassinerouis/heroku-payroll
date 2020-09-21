package customers.project.demo.web;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

import com.fasterxml.jackson.databind.ObjectMapper;

import customers.project.demo.entities.Action;
import customers.project.demo.entities.Documentation;
import customers.project.demo.entities.Pays;
import customers.project.demo.services.ActionService;
import customers.project.demo.services.PaysService;
@RestController
@CrossOrigin
public class PaysController {
	public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads/pays/";

	@Autowired
	PaysService paysservice;

	@PostMapping("/savePays")
	public void save(@RequestParam("file") MultipartFile file,@RequestParam("pays") String pays_infos) {
		System.out.println(file.getName());
		try {
			Pays pays = new ObjectMapper().readValue(pays_infos,Pays.class);
			StringBuilder fileNames = new StringBuilder();
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			  fileNames.append(file.getOriginalFilename()+" ");
			  Files.write(fileNameAndPath, file.getBytes());
			
			pays.setLogo(file.getOriginalFilename());
			paysservice.addPays(pays);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
	@GetMapping("/getPays")
	public List<Pays> getAll() {
		
		System.out.println(uploadDirectory);
		return paysservice.getPays();
	}
	@GetMapping("/getPays/{reglementation}")
	public Pays getPays(@PathVariable String reglementation) {
		System.out.println(reglementation);
		return paysservice.getPaysByReglementation(reglementation);
	}
	@PutMapping("/updatePays")
	public void updateaction(@RequestParam(required=false) MultipartFile file,@RequestParam("pays") String pays_infos) {
		try {
			Pays pays = new ObjectMapper().readValue(pays_infos,Pays.class);
			if(file==null) {
				int id=pays.getCode();
				pays.setLogo(paysservice.getOnePays(id).getLogo());
			}else {
				StringBuilder fileNames = new StringBuilder();
				Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
				fileNames.append(file.getOriginalFilename()+" ");
				Files.write(fileNameAndPath, file.getBytes());
				pays.setLogo(file.getOriginalFilename());
			}
			paysservice.updatePays(pays);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
	@DeleteMapping("/deletePays/{id}")
	public void delete(@PathVariable("id") int id) {
		paysservice.deletePays(id);
	}
}