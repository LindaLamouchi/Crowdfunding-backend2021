package crowdfunding.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Contrat {

	/**
	 * @param Id
	 * @param montant
	 * @param dateCreation
	 * @param projet
	 * @param donateur
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private double montant;

	private String dateCreation;

	@ManyToOne(cascade=CascadeType.ALL) 
	private Projet projet ;

	@ManyToOne(cascade=CascadeType.ALL) 
	private User donateur;





	public Contrat(Long Id, double montant, String dateCreation, Projet projet, User donateur) {
		this.Id = Id;
		this.montant = montant;
		this.dateCreation = dateCreation;
		this.projet = projet;
		this.donateur = donateur;
	}

	/**
	 * 
	 */
	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public User getDonateur() {
		return donateur;
	}

	public void setDonateur(User donateur) {
		this.donateur = donateur;
	}



}
