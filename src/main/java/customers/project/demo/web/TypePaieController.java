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

import customers.project.demo.entities.TypePaie;
import customers.project.demo.services.TypePaieService;

@RestController
@CrossOrigin
public class TypePaieController {
	@Autowired
	 TypePaieService typepaieservice;
	@PostMapping("/savetypepaie")
	public void save(@RequestBody TypePaie typepaie) {
		typepaieservice.addtypepaie(typepaie);
	}
	@GetMapping("/gettypepaie")
	public List<TypePaie> getAll() {
		return typepaieservice.gettypepaie();
	}
	@PutMapping("/updatetypepaie")
	public void updatetypepaie(@RequestBody TypePaie typepaie) {
		typepaieservice.updatetypepaie(typepaie);
	}
	@DeleteMapping("/deletetypepaie/{id}")
	public void delete(@PathVariable("id") int id) {
		typepaieservice.deletetypepaie(id);
	}
}