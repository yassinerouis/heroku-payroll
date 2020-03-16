package customers.project.demo.entities;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class EspaceTravail implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String libelle;
private String description;
@OneToMany(mappedBy="espacetravail")
private Set<Action> actions=new HashSet<Action>();
public Set<Action> getActions() {
	return actions;
}
public void setActions(Set<Action> actions) {
	this.actions = actions;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}
