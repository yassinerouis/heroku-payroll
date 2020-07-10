package customers.project.demo.web;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import customers.project.demo.entities.SousLien;
import customers.project.demo.services.LienService;

@RestController
@CrossOrigin
public class LienController {
	public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads/menu/horizontal";
	@Autowired
	 LienService Lienservice;
	@PostMapping("/menuHorizontal/saveLien")
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
	@GetMapping("/menuHorizontal/getLiens")
	public List<Lien> getAll() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date1=sdf.parse("09/07/1997");
			Date date2=sdf.parse("29/05/2020");
			long diff=date2.getYear()-date1.getYear();
			System.out.println(diff);
					} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Lienservice.getLiensHorizonatl();
		
	}
	@PutMapping("/menuHorizontal/updateLien")
	public void updateLien(@RequestParam(required=false) MultipartFile file,@RequestParam("lien") String lien_menu) {
		try {
			Lien lien = new ObjectMapper().readValue(lien_menu,Lien.class);

			if(file==null) {
				System.out.println("hi");
				int id=lien.getId();
				lien.setLogo(Lienservice.getLien(id).getLogo());
			}else {
				StringBuilder fileNames = new StringBuilder();
				Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
				fileNames.append(file.getOriginalFilename()+" ");
				Files.write(fileNameAndPath, file.getBytes());
			}
			lien.setMenu("H");
			Lienservice.updateLien(lien);
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	@DeleteMapping("/deleteLienHorizontal/{id}")
	public void delete(@PathVariable("id") int id) {
		Lienservice.deleteLien(id);
	}
	@DeleteMapping("/deleteLienVertical/{id}")
	public void deleteVertical(@PathVariable("id") int id) {
		Lienservice.deleteLien(id);
	}
	@PostMapping("/menuvertical/saveLien")
	public Lien savevertical(@RequestBody Lien lien) {
		try {
			lien.setMenu("V");
			Lienservice.addLien(lien);
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return lien;
	}
	@GetMapping("/menuVertical/getLiens")
	public List<Lien> getAllVertical() {
		return Lienservice.getLiensVertical();
	}
	@GetMapping("/getSousLien/{id}")
	public List<SousLien> getSousLiens(@PathVariable("id") int id) {
		return Lienservice.getSousLiens(id);
	}
	@PutMapping("/menuVertical/updateLien")
	public void updateLienVertical(@RequestBody Lien lien) {
		try {
			lien.setMenu("V");
			Lienservice.updateLien(lien);
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@PutMapping("/lien_up/{id_lien}")
	public void upLien(@PathVariable int id_lien) {
		Lienservice.upLien(id_lien);
	}
	@PutMapping("/lien_down/{id_lien}")
	public void downLien(@PathVariable int id_lien) {
		Lienservice.downLien(id_lien);
	}
}
