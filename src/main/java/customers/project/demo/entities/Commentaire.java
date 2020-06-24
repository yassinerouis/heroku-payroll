package customers.project.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Commentaire implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
	@ManyToOne
	
	private ActiviteSuivi activite;
	@ManyToOne
	
	private Utilisateur utilisateur;
	String date_commentaire;
	@Convert(converter = StringListConverter.class)
	private List<String> fichiers;
public List<String> getFichiers() {
		return fichiers;
	}
	public void setFichiers(List<String> fichiers) {
		this.fichiers = fichiers;
	}
public String getDate_commentaire() {
		return date_commentaire;
	}
	public void setDate_commentaire(String date_commentaire) {
		this.date_commentaire = date_commentaire;
	}
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
public long getId() {
	return id;
}
public void setId(long id) {
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
