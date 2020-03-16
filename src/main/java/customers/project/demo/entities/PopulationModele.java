package customers.project.demo.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PopulationModele implements Serializable{
	private static final long serialVersionUID = 1L;
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getDate_debut() {
		return Date_debut;
	}

	public void setDate_debut(Date date_debut) {
		Date_debut = date_debut;
	}

	public Date getDate_fin() {
		return Date_fin;
	}

	public void setDate_fin(Date date_fin) {
		Date_fin = date_fin;
	}
	public TypePopulation getPopulation() {
		return typepopulation;
	}
	public void setPopulation(TypePopulation typepopulation) {
		this.typepopulation = typepopulation;
	}
	public Modele getModele() {
		return modele;
	}
	public void setModele(Modele modele) {
		this.modele = modele;
	}
	public TypePopulation getTypepopulation() {
		return typepopulation;
	}

	public void setTypepopulation(TypePopulation typepopulation) {
		this.typepopulation = typepopulation;
	}
	@javax.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Temporal(TemporalType.DATE)
	private Date Date_debut;
	@Temporal(TemporalType.DATE)
	private Date Date_fin;
	@ManyToOne(fetch = FetchType.LAZY)
	private TypePopulation typepopulation;
	@ManyToOne(fetch = FetchType.LAZY)
	private Modele modele;
}