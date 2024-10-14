package pe.com.utp.service.support.payrollCollaborator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.utp.service.support.payrollCollaborator.model.PayrollCollaborator;

@Repository
public interface PayrollCollaboratorRepository extends JpaRepository<PayrollCollaborator, Integer> {

}
