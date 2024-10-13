package pe.com.utp.service.uit.business;

import pe.com.utp.service.uit.dto.UitResponse;
import pe.com.utp.service.uit.exception.ServiceException;

import java.io.IOException;

public interface UitService {
	
	public UitResponse getUit() throws IOException;

}
