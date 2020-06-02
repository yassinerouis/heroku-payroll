package customers.project.demo.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class ResponsabiliteModeleSuivi implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	public Utilisateur getPayrollmanager() {
		return payrollmanager;
	}
	public void setPayrollmanager(Utilisateur payrollmanager) {
		this.payrollmanager = payrollmanager;
	}
	public ModeleSuivi getModeleSuivi() {
		return modelesuivi;
	}
	public void setModeleSuivi(ModeleSuivi ModeleSuivi) {
		this.modelesuivi = ModeleSuivi;
	}
	private Date date_debut;
	private Date date_fin;
	@ManyToOne
	private Utilisateur payrollmanager;
	@ManyToOne
	private ModeleSuivi modelesuivi;
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
