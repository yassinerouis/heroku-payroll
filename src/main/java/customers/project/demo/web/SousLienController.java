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
import org.springframework.web.bind.annotation.RestController;

import customers.project.demo.entities.SousLien;
import customers.project.demo.services.SousLienService;
@RestController
@CrossOrigin
public class SousLienController {


	@Autowired
	 SousLienService souslienservice;
	@PostMapping("/savesouslien")
	public void save(@RequestBody SousLien souslien) {
		souslienservice.addsousLien(souslien);
	}
	@GetMapping("/getsouslien")
	public List<SousLien> getAll() {
		return souslienservice.getsousLien();
	}
	@PutMapping("/updatesouslien")
	public void updatesouslien(@RequestBody SousLien souslien) {
		souslienservice.updatesousLien(souslien);
	}
	@DeleteMapping("/deletesouslien/{id}")
	public void delete(@PathVariable("id") int id) {
		souslienservice.deletesousLien(id);
	}
}
