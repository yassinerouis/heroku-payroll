package customers.project.demo.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Compte implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String nomutilisateur;
	private String motdepasse;
	public String getNomutilisateur() {
		return nomutilisateur;
	}
	public void setNomutilisateur(String nomutilisateur) {
		this.nomutilisateur = nomutilisateur;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
}
