package customers.project.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private static final long serialVersionUID = 1L;
	@Id
	@Column(length = 6)
	private String matricule;
	@Column(length = 3)
	private String reglementation;
	public String getReglementation() {
		return reglementation;
	}
	public void setReglementation(String reglemenatation) {
		this.reglementation = reglemenatation;
	}
	private String nom;
	private String prenom;
	private String societe;
	private String etablissement;
	private String emploi;
	private String statut;
	private String photo;
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getSociete() {
		return societe;
	}
	public void setSociete(String societe) {
		this.societe = societe;
	}
	public String getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	public String getEmploi() {
		return emploi;
	}
	public void setEmploi(String emploi) {
		this.emploi = emploi;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Set<ResponsabiliteActivite> getRespoactivite() {
		return respoactivite;
	}
	public void setRespoactivite(Set<ResponsabiliteActivite> respoactivite) {
		this.respoactivite = respoactivite;
	}
	public Set<ResponsabiliteModele> getRespomodele() {
		return respomodele;
	}
	public void setRespomodele(Set<ResponsabiliteModele> respomodele) {
		this.respomodele = respomodele;
	}

	
	private String role;
	@OneToMany(mappedBy = "payroll")
	@JsonIgnore
	private Set<ResponsabiliteActivite> respoactivite=new HashSet<ResponsabiliteActivite>();
	@OneToMany(mappedBy = "payrollmanager")
	@JsonIgnore
	private Set<ResponsabiliteModele> respomodele=new HashSet<ResponsabiliteModele>();
	
}
