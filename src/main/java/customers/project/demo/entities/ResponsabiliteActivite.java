package customers.project.demo.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class ResponsabiliteActivite implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	Long id;
	private Date date_debut;
	private Date date_fin;
	@ManyToOne(fetch = FetchType.LAZY)
	private Payroll payroll;
	@ManyToOne(fetch = FetchType.LAZY)
	private Activite activite;
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
