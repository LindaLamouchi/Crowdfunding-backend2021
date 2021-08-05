package crowdfunding.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class Domaine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long domaineId;

    private String libelle;
    
    @OneToMany(mappedBy="domaine")
    @JsonIgnore
    private List<Projet> projets=new ArrayList<Projet>();

    
    
	public Long getDomaineId() {
		return domaineId;
	}

	public void setDomaineId(Long domaineId) {
		this.domaineId = domaineId;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	

	public List<Projet> getprojets() {
		return projets;
	}

	public void setprojets(List<Projet> projets) {
		this.projets = projets;
	}
	
	

	

	public Domaine(Long domaineId, String libelle, List<Projet> projets) {
		super();
		this.domaineId = domaineId;
		this.libelle = libelle;
		this.projets = projets;
	}


	public Domaine() {
		super();
	}
    
    
}
