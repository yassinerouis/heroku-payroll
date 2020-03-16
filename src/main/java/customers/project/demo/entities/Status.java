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
public class Status implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int identifiant;
	public Set<Activite> getActivite() {
		return activite;
	}
	public void setActivite(Set<Activite> activite) {
		this.activite = activite;
	}
	public Set<Action> getAction() {
		return action;
	}
	public void setAction(Set<Action> action) {
		this.action = action;
	}
	private String libelle;
	private String description;
	@OneToMany(mappedBy="status")
	private Set<Activite> activite=new HashSet<Activite>();

	@OneToMany(mappedBy="status")
	private Set<Action> action=new HashSet<Action>();
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
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
