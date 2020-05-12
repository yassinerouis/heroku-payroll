package customers.project.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Commentaire implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	@ManyToOne
	private ActiviteSuivi activite;
	@ManyToOne
	private Utilisateur utilisateur;
	
public ActiviteSuivi getActivite() {
		return activite;
	}
	public void setActivite(ActiviteSuivi activite) {
		this.activite = activite;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getContenu() {
	return contenu;
}
public void setContenu(String contenu) {
	this.contenu = contenu;
}
private String contenu;
}
