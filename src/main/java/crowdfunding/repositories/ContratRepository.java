package crowdfunding.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crowdfunding.models.Contrat;


@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {

}
