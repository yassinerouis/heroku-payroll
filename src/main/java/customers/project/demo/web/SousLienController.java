package customers.project.demo.web;

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

import com.fasterxml.jackson.databind.ObjectMapper;

import customers.project.demo.entities.Lien;
import customers.project.demo.entities.SousLien;
import customers.project.demo.services.SousLienService;
@RestController
@CrossOrigin
public class SousLienController {
	@Autowired
	 SousLienService souslienservice;
	@PutMapping("/menuVertical/updateSousLien")
	public void updateSousLienVertical(@RequestBody List<SousLien> sous_lien) {
		
		try {
			for(int i=0;i<sous_lien.size();i++) {
				souslienservice.updatesousLien(sous_lien.get(i));
			}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
