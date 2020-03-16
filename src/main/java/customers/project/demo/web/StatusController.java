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
import customers.project.demo.entities.Status;
import customers.project.demo.services.StatusService;

@RestController
@CrossOrigin
public class StatusController {
	@Autowired
	 StatusService statusservice;
	@PostMapping("/savestatus")
	public void save(@RequestBody Status status) {
		statusservice.addStatus(status);
	}
	@GetMapping("/getstatus")
	public List<Status> getAll() {
		return statusservice.getStatus();
	}
	@PutMapping("/updatestatus")
	public void updateStatus(@RequestBody Status status) {
		statusservice.updateStatus(status);
	}
	@DeleteMapping("/deletestatus/{id}")
	public void delete(@PathVariable("id") int id) {
		statusservice.deleteStatus(id);
	}
}