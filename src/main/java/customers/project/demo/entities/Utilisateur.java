package customers.project.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Utilisateur  implements Serializable{
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private static final long serialVersionUID = 1L;
	@Id
	private String matricule;
	private String nom;
	private String prenom;
	private String adresse;
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Set<Commentaire> getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(Set<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}
	private String email;
	@OneToOne
	private Compte compte;
	@Temporal(TemporalType.DATE)
	private Date date_naissance;
	private String role;
	@OneToMany(mappedBy = "payroll")
	@JsonIgnore
	private Set<ResponsabiliteActivite> respoactivite=new HashSet<ResponsabiliteActivite>();
	@OneToMany(mappedBy = "payrollmanager")
	@JsonIgnore
	private Set<ResponsabiliteModele> respomodele=new HashSet<ResponsabiliteModele>();
	@OneToMany(mappedBy="utilisateur")
	private Set<Commentaire> commentaire=new HashSet<Commentaire>();
}
