package crowdfunding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crowdfunding.models.User;
import crowdfunding.repositories.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserCntrlCotroller {
	@Autowired
	private UserRepository UserRepository;
	@GetMapping("/all")
	public List<User> allUsers() {
		return UserRepository.findAll();
	}
	@PutMapping("/Profile/{id}")
	public ResponseEntity<String> UpdateProfile(@PathVariable Long id,@RequestBody User u){
		User user= UserRepository.findById(id).get();
		user.setPassword(u.getPassword());
		user.setUsername(u.getUsername());
		user.setEmail(u.getEmail());
		UserRepository.save(user);
		return new ResponseEntity<>("Profile modifié avec succes", HttpStatus.OK);

	}
}
