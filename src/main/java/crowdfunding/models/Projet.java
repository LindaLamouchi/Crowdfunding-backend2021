package crowdfunding.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Projet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titre;
	
	private String contexte;
	
	private String etat;
	
	@ManyToOne(cascade=CascadeType.ALL) 
	private User responsable;
	
	private double budget_But;
	
	private double budget_collecte;

	 @OneToMany(mappedBy="projet")
	 @JsonIgnore
	private List<Contrat> contrat;

    @ManyToOne(cascade=CascadeType.ALL) 
    private Domaine domaine;
    
    
	/**
	 * @param id
	 * @param titre
	 * @param contexte
	 * @param etat
	 * @param responsable
	 * @param budget_But
	 * @param budget_collecte
	 * @param contrat
	 * @param domaine
	 */
	public Projet( String titre, String contexte, String etat, User responsable, double budget_But,
			double budget_collecte, List<Contrat> contrat, Domaine domaine) {
		
		this.titre = titre;
		this.contexte = contexte;
		this.etat = etat;
		this.responsable = responsable;
		this.budget_But = budget_But;
		this.budget_collecte=budget_collecte;
		this.contrat = contrat;
		this.domaine = domaine;
	}

	public Projet() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContexte() {
		return contexte;
	}

	public void setContexte(String contexte) {
		this.contexte = contexte;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public User getResponsable() {
		return responsable;
	}

	public void setResponsable(User responsable) {
		this.responsable = responsable;
	}

	public double getBudget_But() {
		return budget_But;
	}

	public void setBudget_But(double budget_But) {
		this.budget_But = budget_But;
	}

	public double getBudget_collecte() {
		return budget_collecte;
	}


	public void setBudget_collecte(double budget_collecte) {
		this.budget_collecte = budget_collecte;
	}

	public List<Contrat> getContrat() {
		return contrat;
	}

	public void setContrat(List<Contrat> contrat) {
		this.contrat = contrat;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}
	
}
