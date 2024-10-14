package pe.com.utp.service.support.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.utp.service.support.payroll.model.Payroll;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Integer> {

}
