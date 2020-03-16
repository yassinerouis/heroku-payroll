package customers.project.demo.entities;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Lien implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id

private int id;
private String libelle;
private String description;
@ManyToMany(mappedBy = "liens")
private Set<Menu> menus;

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
