package pe.com.utp.service.support.collaborator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.utp.service.support.collaborator.model.Collaborator;

import java.util.Optional;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Integer> {

    Optional<Collaborator> findByCodigoModular(Long codigoModular);

}
