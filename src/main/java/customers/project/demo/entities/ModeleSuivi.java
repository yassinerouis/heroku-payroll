package customers.project.demo.entities;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class ModeleSuivi implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	long code_modele;
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private TypePopulation typepopulation;
	public TypePopulation getTypepopulation() {
		return typepopulation;
	}
	public void setTypepopulation(TypePopulation typepopulation) {
		this.typepopulation = typepopulation;
	}
	public ModeleSuivi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setModele(ModeleSuivi modelesuivi) {
		this.setcible(modelesuivi.cible);
		this.setLibelle(modelesuivi.libelle);
		this.setReglementation(modelesuivi.reglementation);
		this.setTypepaie(modelesuivi.typepaie);
		this.setFrequence(modelesuivi.frequence);
	}
	public void setModeleSuivi(Modele modele) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = null;
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), modele.getDate_cible());
	    Date date=calendar.getTime();
	    formater = new SimpleDateFormat("EEEE");
	    if(formater.format(date).equals("samedi")) {
	    	calendar.add(Calendar.DATE, -1);
	    }else if(formater.format(date).equals("dimanche")) {
	    	calendar.add(Calendar.DATE,1);
	    }
		this.setcible(calendar.getTime());
		this.setLibelle(modele.getLibelle());
		this.setReglementation(modele.getReglementation());
		this.setTypepaie(modele.getTypepaie());
		this.setTypepopulation(modele.getTypepopulation());
		this.setFrequence(modele.getFrequence());
	}
	String libelle;
	String reglementation;
	@Temporal(TemporalType.DATE)
	Date cible;
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
	public Set<Suivi> getSuivis() {
		return suivis;
	}
	public void setSuivis(Set<Suivi> suivis) {
		this.suivis = suivis;
	}
	
	@OneToMany(mappedBy = "modele")
	@JsonIgnore

	private Set<ResponsabiliteModele> respomodele=new HashSet<ResponsabiliteModele>();
	@OneToMany(mappedBy = "modele")
	@JsonIgnore
	private Set<Suivi> suivis=new HashSet<Suivi>();
	@Temporal(TemporalType.DATE)
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
	
	public Date getcible() {
		return cible;
	}
	public void setcible(Date cible) {
		this.cible = cible;
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
	long modele_principal;
	public long getModele_principal() {
		return modele_principal;
	}
	public void setModele_principal(long modele_principal) {
		this.modele_principal = modele_principal;
	}
}
