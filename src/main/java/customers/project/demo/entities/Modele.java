package customers.project.demo.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Modele implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	long code_modele;
	
	public Modele() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setModele(Modele modele) {
		this.setDate_virement(modele.date_virement);
		this.setLibelle(modele.libelle);
		this.setReglementation(modele.reglementation);
		this.setTypepaie(modele.typepaie);
		this.setFrequence(modele.frequence);
	}
	String libelle;
	String reglementation;
	
	int date_virement;
	@Temporal(TemporalType.DATE)
	private Date date_creation;
	public TypePaie getTypepaie() {
		return typepaie;
	}
	public void setTypepaie(TypePaie typepaie) {
		this.typepaie = typepaie;
	}
	
	@Temporal(TemporalType.DATE)
	private Date date_modification;
	@ManyToOne
	private Frequence frequence;
	@ManyToOne(cascade = javax.persistence.CascadeType.PERSIST)
	private TypePaie typepaie;
	
	public Frequence getFrequence() {
		return frequence;
	}
	public void setFrequence(Frequence frequence) {
		this.frequence = frequence;
	}
	public Set<ResponsabiliteModele> getRespomodele() {
		return respomodele;
	}
	public void setRespomodele(Set<ResponsabiliteModele> respomodele) {
		this.respomodele = respomodele;
	}
	/*
	public Set<Suivi> getSuivis() {
		return suivis;
	}
	public void setSuivis(Set<Suivi> suivis) {
		this.suivis = suivis;
	}*/
	
	@OneToMany(mappedBy = "modele")
	@JsonIgnore

	private Set<ResponsabiliteModele> respomodele=new HashSet<ResponsabiliteModele>();
	/*@OneToMany(mappedBy = "modele")
	@JsonIgnore
	private Set<Suivi> suivis=new HashSet<Suivi>();*/
	
	public long getCode_modele() {
		return code_modele;
	}
	public void setCode_modele(long code_modele) {
		this.code_modele = code_modele;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getReglementation() {
		return reglementation;
	}
	public void setReglementation(String reglementation) {
		this.reglementation = reglementation;
	}
	
	public int getDate_virement() {
		return date_virement;
	}
	public void setDate_virement(int date_virement) {
		this.date_virement = date_virement;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public Date getDate_modification() {
		return date_modification;
	}
	public void setDate_modification(Date date_modification) {
		this.date_modification = date_modification;
	}
	
	public Date getDate_suppression() {
		return date_suppression;
	}
	public void setDate_suppression(Date date_suppression) {
		this.date_suppression = date_suppression;
	}
	
	
	@Temporal(TemporalType.DATE)
	private Date date_suppression;
	
}
