package pe.com.utp.service.support.payrollCollaborator.business.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.utp.service.support.payrollCollaborator.business.PayrollCollaboratorService;
import pe.com.utp.service.support.payrollCollaborator.dto.BodyResponse;
import pe.com.utp.service.support.payrollCollaborator.dto.PayrollCollaboratorRequest;
import pe.com.utp.service.support.payrollCollaborator.exception.DBException;
import pe.com.utp.service.support.payrollCollaborator.model.PayrollCollaborator;
import pe.com.utp.service.support.payrollCollaborator.repository.PayrollCollaboratorRepository;
import pe.com.utp.service.support.payrollCollaborator.util.PayrollCollaboratorUtil;

@Slf4j
@Service
public class PayrollCollaboratorServiceImpl implements PayrollCollaboratorService {

	private PayrollCollaboratorRepository repository;

	public PayrollCollaboratorServiceImpl(PayrollCollaboratorRepository repository) {
		this.repository = repository;
	}

	@Override
	public BodyResponse createPayrollCollaborator(PayrollCollaboratorRequest request, String correlatorId) throws DBException{

		BodyResponse response = new BodyResponse();

		try {
			repository.save(setPayrollCollaborator(request, response));

			response.setIdTransaction(correlatorId);
			response.setCode("0");
			response.setMessage("Proceso exitoso");

		} catch (DataAccessException e) {
			throw new DBException("-1", "[Error]: no se pudo registrar planilla en la base de datos 'quinta_categoria', [ERROR]: " + e.getMessage(), e);
		}

        return response;
	}


	public PayrollCollaborator setPayrollCollaborator(PayrollCollaboratorRequest request, BodyResponse response) {

		PayrollCollaborator payrollCollaborator = new PayrollCollaborator();

		payrollCollaborator.setIdPlanilla(Integer.valueOf(request.getIdPlanilla()));
		payrollCollaborator.setIdColaborador(Integer.valueOf(request.getIdColaborador()));
		payrollCollaborator.setTotalHaber(Double.valueOf(request.getTotalHaber()));
		payrollCollaborator.setTotalDescuento(Double.valueOf(request.getTotalDescuento()));

		repository.save(payrollCollaborator);

		response.setIdRegistry(String.valueOf(payrollCollaborator.getIdPlanillaColaborador()));

		return payrollCollaborator;
	}

}
