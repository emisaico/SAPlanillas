package pe.com.utp.service.support.payroll.business;

import pe.com.utp.service.support.payroll.dto.BodyResponse;
import pe.com.utp.service.support.payroll.dto.PayrollRequest;
import pe.com.utp.service.support.payroll.exception.DBException;


public interface PayrollService {

	public BodyResponse createPayroll(PayrollRequest request, String correlatorId) throws DBException;

}
