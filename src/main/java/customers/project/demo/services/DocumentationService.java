package customers.project.demo.services;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.DocumentationRepository;
import customers.project.demo.entities.Action;
import customers.project.demo.entities.Documentation;
import customers.project.demo.entities.Documentation;

@Service
@Transactional
public class DocumentationService {
	@Autowired
DocumentationRepository documentationrepository;
	public Documentation addDocument(Documentation document) {
		return documentationrepository.save(document);
	}
	public List<Documentation> getDocuments(){
		return documentationrepository.findAll();
	}
	public void updateDocumentation(Documentation documentation) {
		documentationrepository.getOne(documentation.getIdentifiant()).
		setTitre(documentation.getTitre());
		documentationrepository.getOne(documentation.getIdentifiant()).
		setNom(documentation.getNom());
		documentationrepository.getOne(documentation.getIdentifiant()).
		setNom(documentation.getNom());
		documentationrepository.getOne(documentation.getIdentifiant()).
		setPays(documentation.getPays());
		documentationrepository.getOne(documentation.getIdentifiant()).
		setType(documentation.getType());
		documentationrepository.getOne(documentation.getIdentifiant()).
		setFile(documentation.getFile());
	}
	public void deleteDocumentation(Integer id) {
		documentationrepository.deleteById(id);
	}
}
