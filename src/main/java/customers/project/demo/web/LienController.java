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

import customers.project.demo.entities.Documentation;
import customers.project.demo.entities.Lien;
import customers.project.demo.services.LienService;

@RestController
@CrossOrigin
public class LienController {
	public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads/menu/";
	@Autowired
	 LienService Lienservice;
	@PostMapping("/menuhorizontal/saveLien")
	public void save(@RequestParam("logo") MultipartFile file,@RequestParam("lien") String lien_menu) {
		try {
			Lien lien = new ObjectMapper().readValue(lien_menu,Lien.class);
			StringBuilder fileNames = new StringBuilder();
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename()+" ");
			Files.write(fileNameAndPath, file.getBytes());
			lien.setMenu("H");
			Lienservice.addLien(lien);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@GetMapping("/menuhorizontal/getLiens")
	public List<Lien> getAll() {
		
		return Lienservice.getLien();
	}
	@PutMapping("/menuhorizontal/updateLien")
	public void updateLien(@RequestParam("logo") MultipartFile file,@RequestParam("lien") String lien_menu) {
		try {
			Lien lien = new ObjectMapper().readValue(lien_menu,Lien.class);
			StringBuilder fileNames = new StringBuilder();
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename()+" ");
			Files.write(fileNameAndPath, file.getBytes());
			lien.setMenu("H");
			Lienservice.updateLien(lien);
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	@DeleteMapping("/deleteLien/{id}")
	public void delete(@PathVariable("id") int id) {
		Lienservice.deleteLien(id);
	}
	@PostMapping("/menuvertical/saveLien")
	public void savevertical(@RequestParam("logo") MultipartFile file,@RequestParam("lien") String lien_menu) {
		try {
			Lien lien = new ObjectMapper().readValue(lien_menu,Lien.class);
			StringBuilder fileNames = new StringBuilder();
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename()+" ");
			Files.write(fileNameAndPath, file.getBytes());
			lien.setMenu("V");
			Lienservice.addLien(lien);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@GetMapping("/menuvertical/getLiens")
	public List<Lien> getAllVertical() {
		
		return Lienservice.getLien();
	}
	@PutMapping("/menuvertical/updateLien")
	public void updateLienVertical(@RequestParam("logo") MultipartFile file,@RequestParam("lien") String lien_menu) {
		try {
			Lien lien = new ObjectMapper().readValue(lien_menu,Lien.class);
			StringBuilder fileNames = new StringBuilder();
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename()+" ");
			Files.write(fileNameAndPath, file.getBytes());
			lien.setMenu("V");
			Lienservice.updateLien(lien);
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
