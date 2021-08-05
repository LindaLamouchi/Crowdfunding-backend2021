package crowdfunding.controller;

import java.util.List;
import java.util.Optional;

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

import crowdfunding.models.Domaine;
import crowdfunding.models.Projet;
import crowdfunding.repositories.DomaineRepository;
import crowdfunding.repositories.ProjetRepository;



@RestController
@RequestMapping("/domaines")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DomaineController {

	@Autowired
	private DomaineRepository domaineRepository;

	@Autowired
	private ProjetRepository projetRepository;


	@GetMapping(value = "/All")
	public List<Domaine> getdomaines(){
		return domaineRepository.findAll();
	}

	@GetMapping(value = "/ById/{id}")
	public Domaine getdomaine(@PathVariable Long id){
		return domaineRepository.findById(id).orElseThrow(null);
	}

	@PostMapping(value = "/nouveauDomaine/")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> adddomaine(@RequestBody Domaine domaine){
		domaineRepository.save(domaine);
		return new ResponseEntity<>("Domaine added successfully", HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteAll/")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deletealldomaines(){
		domaineRepository.deleteAll();
		return new ResponseEntity<>("All domaines deleted successfully", HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteById/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteadomaine(@PathVariable Long id){
		List<Projet> l=projetRepository.findAll();
		for (Projet projet : l) {
			if(projet.getDomaine()!=null)
				if(projet.getDomaine().getDomaineId()==id)
					projet.setDomaine(null);
		}
		domaineRepository.deleteById(id);
		return new ResponseEntity<>("Domaine deleted successfully", HttpStatus.OK);
	}

}
