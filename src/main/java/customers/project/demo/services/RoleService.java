package customers.project.demo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.RoleRepository;
import customers.project.demo.entities.Role;

@Service
@Transactional
public class RoleService {
	@Autowired
	RoleRepository rolerepository;
	public void addRole(Role role) {
		rolerepository.save(role);
	}
}
