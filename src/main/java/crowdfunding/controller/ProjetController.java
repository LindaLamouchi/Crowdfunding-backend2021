package crowdfunding.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crowdfunding.models.Contrat;
import crowdfunding.models.Domaine;
import crowdfunding.models.Projet;
import crowdfunding.models.User;
import crowdfunding.repositories.ContratRepository;
import crowdfunding.repositories.DomaineRepository;
import crowdfunding.repositories.ProjetRepository;
import crowdfunding.repositories.UserRepository;


@RestController
@RequestMapping("/projets")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjetController {

	@Autowired
	private ProjetRepository projetRepository;
	@Autowired
	private DomaineRepository domaineRepository;
	@Autowired
	private  UserRepository userRepository;
	@Autowired
	private ContratRepository contratRepository;

	@GetMapping(value="/all/")
	public List<Projet> getProjets(){
		return projetRepository.findAll();
	}
	
	@GetMapping(value="/all/{id}")
	public List<Projet> getProjets(@PathVariable Long id){
		List<Projet> x = projetRepository.findAll();
		List<Projet> x2=new ArrayList<Projet>();
		for (Projet projet : x) {
			if (projet.getResponsable().getId()==id)
				x2.add(projet);
		}
		return x2;
	}
	@GetMapping(value = "/ById/{id}")
	public Projet getProjet(@PathVariable Long id) {
		// Montant collecté
		double d=0;
		Projet p=projetRepository.findById(id).get();
		d=p.getBudget_collecte();
		List<Contrat> h=new ArrayList<>();
		h=contratRepository.findAll();
		for (Contrat c : h) {
			if(c.getProjet()==p) {
				d=d+c.getMontant();
			}
		}
		p.setBudget_collecte(d);
		return projetRepository.findById(id).get();
	}
	//delete + update
	@PostMapping(value = "/nouveauProjet/{idDomaine}/{idResponsable}")
	public ResponseEntity<String> addProjet(@RequestBody Projet projet, @PathVariable Long idDomaine, @PathVariable Long idResponsable){
		Domaine d=domaineRepository.findById(idDomaine).get();
		projet.setDomaine(d);
		User u=userRepository.findById(idResponsable).get();
		projet.setResponsable(u);

		projetRepository.save(projet);
		return new ResponseEntity<>("Projet ajouté avec succes", HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<String> deleteProjet(@PathVariable Long id){

		List<Contrat> c=contratRepository.findAll();
		for (Contrat contrat : c) {
			if(contrat.getProjet().getId()==id)
				return new ResponseEntity<>("Operation Illégale!", HttpStatus.OK);
		}
		Projet p=projetRepository.findById(id).get();
		p.setResponsable(null);
		p.setDomaine(null);

		projetRepository.deleteById(id);
		return new ResponseEntity<>("Projet Supprimé avec succes", HttpStatus.OK);



	}


}
