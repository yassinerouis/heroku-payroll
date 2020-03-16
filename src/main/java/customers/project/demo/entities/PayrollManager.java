package customers.project.demo.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class PayrollManager implements Serializable{
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	private static final long serialVersionUID = 1L;
	@Id

	private String matricule;
	private String nom;
	private String prenom;
	private String email;
	@OneToOne
	private Compte compte;
	private Date date_naissance;
	private String photo;
	@OneToMany(mappedBy = "payrollmanager")
	@JsonIgnore
	private Set<ResponsabiliteModele> respomodele=new HashSet<ResponsabiliteModele>();
	
	@OneToMany(mappedBy="payrollmanager")
	private Set<Commentaire> commentaire=new HashSet<Commentaire>();
}
