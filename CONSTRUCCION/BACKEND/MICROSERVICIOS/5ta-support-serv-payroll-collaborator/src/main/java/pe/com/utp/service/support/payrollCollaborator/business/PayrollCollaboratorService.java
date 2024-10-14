package pe.com.utp.service.support.payrollCollaborator.business;

import pe.com.utp.service.support.payrollCollaborator.dto.BodyResponse;
import pe.com.utp.service.support.payrollCollaborator.dto.PayrollCollaboratorRequest;
import pe.com.utp.service.support.payrollCollaborator.exception.DBException;


public interface PayrollCollaboratorService {

	public BodyResponse createPayrollCollaborator(PayrollCollaboratorRequest request, String correlatorId) throws DBException;

}
