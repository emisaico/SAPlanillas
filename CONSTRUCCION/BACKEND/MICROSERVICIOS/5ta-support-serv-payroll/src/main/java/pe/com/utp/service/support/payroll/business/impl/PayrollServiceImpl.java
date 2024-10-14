package pe.com.utp.service.support.payroll.business.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.utp.service.support.payroll.business.PayrollService;
import pe.com.utp.service.support.payroll.dto.BodyResponse;
import pe.com.utp.service.support.payroll.dto.PayrollRequest;
import pe.com.utp.service.support.payroll.exception.DBException;
import pe.com.utp.service.support.payroll.model.Payroll;
import pe.com.utp.service.support.payroll.repository.PayrollRepository;
import pe.com.utp.service.support.payroll.util.PayrollUtil;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PayrollServiceImpl implements PayrollService {

	private PayrollRepository repository;

	public PayrollServiceImpl(PayrollRepository repository) {
		this.repository = repository;
	}

	@Override
	public BodyResponse createPayroll(PayrollRequest request, String correlatorId) throws DBException{

		BodyResponse response = new BodyResponse();

		try {
			repository.save(setPayroll(request, response));

			response.setIdTransaction(correlatorId);
			response.setCode("0");
			response.setMessage("Proceso exitoso");

		} catch (DataAccessException e) {
			throw new DBException("-1", "[Error]: no se pudo registrar planilla en la base de datos 'quinta_categoria', [ERROR]: " + e.getMessage(), e);
		}

        return response;
	}


	public Payroll setPayroll(PayrollRequest request, BodyResponse response) {

		Payroll payroll = new Payroll();

		payroll.setTipoPlanilla(request.getTipoPlanilla());
		payroll.setPeriodo(request.getPeriodo());
		payroll.setCodigoUgel(request.getCodigoUgel());
		payroll.setFechaRegistro(PayrollUtil.convertStringToDate(request.getFechaRegistro()));
		payroll.setFechaModificacion(PayrollUtil.convertStringToDate(request.getFechaModificacion()));

		repository.save(payroll);

		response.setIdRegistry(String.valueOf(payroll.getIdPlanilla()));

		return payroll;
	}

}
