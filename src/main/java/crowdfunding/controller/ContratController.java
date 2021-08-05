package crowdfunding.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crowdfunding.models.Contrat;
import crowdfunding.models.Projet;
import crowdfunding.models.User;
import crowdfunding.repositories.ContratRepository;
import crowdfunding.repositories.ProjetRepository;
import crowdfunding.repositories.UserRepository;





@RestController
@RequestMapping("/purchase")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContratController {

	
	@Autowired
    private ContratRepository contratRepository;
	
	@Autowired
	private UserRepository userRepository;
		
	@Autowired
	private ProjetRepository projetRepository; 
	
	
	 @GetMapping(value = "/all/{id}/")
	    public List<Contrat> getContrats(@PathVariable Long id){
	    	List<Contrat> x= contratRepository.findAll();
	    	List<Contrat> x2 = new ArrayList<>();
	    	
	    	for(Contrat c:x) {
	    		if(c.getDonateur().getId()==id) {
	    			x2.add(c);
	    		}
	    	}
	    	
	    	return x2;
	    	
	    }
	 
	 @GetMapping(value = "/Contrat/{id}/")
	    public Contrat getContrat(@PathVariable Long id){
	        return contratRepository.findById(id).orElseThrow(null);
	    }
	 
	 @PostMapping(value = "/nouveau/{don}/{p}/")
	    public ResponseEntity<String> addContrat(@RequestBody Contrat contrat,@PathVariable Long don,@PathVariable Long p){
		 /**
			 * @param projet : p
			 * @param donateur : don
			 */
		 User u=userRepository.findById(don).get();
		 Projet j= projetRepository.findById(p).get();
		 Contrat c= contrat;
		 c.setDonateur(u);
		 c.setProjet(j);
	        contratRepository.save(c);
	        return new ResponseEntity<>("Contrat est ajouté en succes", HttpStatus.OK);
	    }
	 //contrat ne doit etre modifié ou supprimé
	 
}
