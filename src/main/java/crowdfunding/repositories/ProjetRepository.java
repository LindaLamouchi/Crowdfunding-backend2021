package crowdfunding.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crowdfunding.models.Projet;


@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long>{

}
