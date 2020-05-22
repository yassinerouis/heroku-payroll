package customers.project.demo.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class ResponsabiliteModele implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	public Utilisateur getPayrollmanager() {
		return payrollmanager;
	}
	public void setPayrollmanager(Utilisateur payrollmanager) {
		this.payrollmanager = payrollmanager;
	}
	public Modele getModele() {
		return modele;
	}
	public void setModele(Modele modele) {
		this.modele = modele;
	}
	private Date date_debut;
	private Date date_fin;
	@ManyToOne
	private Utilisateur payrollmanager;
	@ManyToOne
	private Modele modele;
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
}
