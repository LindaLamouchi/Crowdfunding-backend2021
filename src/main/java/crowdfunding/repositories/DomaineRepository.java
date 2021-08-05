package crowdfunding.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crowdfunding.models.Domaine;



@Repository
public interface DomaineRepository extends JpaRepository<Domaine, Long>{
    
}
