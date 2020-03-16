package customers.project.demo.entities;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Menu implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id

	private int id;
	private String libelle;
	private String description;
	private String role;
	@ManyToMany(cascade = CascadeType.ALL)
	
    @JoinTable(name = "menu_lien", joinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "lien_id", referencedColumnName = "id"))
	  private Set<Lien> liens;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
