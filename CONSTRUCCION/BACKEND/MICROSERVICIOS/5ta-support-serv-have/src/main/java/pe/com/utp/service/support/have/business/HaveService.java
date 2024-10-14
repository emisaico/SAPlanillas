package pe.com.utp.service.support.have.business;

import pe.com.utp.service.support.have.dto.BodyResponse;
import pe.com.utp.service.support.have.dto.HaveRequest;
import pe.com.utp.service.support.have.exception.DBException;


public interface HaveService {

	public BodyResponse createHave(HaveRequest request, String correlatorId) throws DBException;

}
