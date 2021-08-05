package crowdfunding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import crowdfunding.models.ERole;
import crowdfunding.models.Role;
import crowdfunding.repositories.RoleRepository;




@SpringBootApplication
@EnableJpaRepositories(basePackages="crowdfunding")
public class crowdfunding implements CommandLineRunner
{
	@Autowired
	private RoleRepository roleRepository;
	public static void main(String[] args) {
		SpringApplication.run(crowdfunding.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    
	   
		// TODO Auto-generated method stub
		  if(roleRepository.findByName(ERole.ROLE_USER)==null){
			    roleRepository.save(new Role(ERole.ROLE_MODERATOR));
	            roleRepository.save(new Role(ERole. ROLE_ADMIN));
	            roleRepository.save(new Role(ERole. ROLE_USER));
	        }
	
	}

}
