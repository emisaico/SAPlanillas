package pe.com.utp.service.support.discount.business;

import pe.com.utp.service.support.discount.dto.BodyResponse;
import pe.com.utp.service.support.discount.dto.DiscountRequest;
import pe.com.utp.service.support.discount.exception.DBException;


public interface DiscountService {

	public BodyResponse createDiscount(DiscountRequest request, String correlatorId) throws DBException;

}
