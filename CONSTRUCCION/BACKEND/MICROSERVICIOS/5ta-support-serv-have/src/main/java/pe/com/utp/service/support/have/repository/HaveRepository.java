package pe.com.utp.service.support.have.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.utp.service.support.have.model.Have;

@Repository
public interface HaveRepository extends JpaRepository<Have, Integer> {

}
