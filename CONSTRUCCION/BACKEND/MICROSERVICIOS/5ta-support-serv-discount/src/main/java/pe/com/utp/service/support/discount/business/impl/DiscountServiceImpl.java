package pe.com.utp.service.support.discount.business.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.utp.service.support.discount.business.DiscountService;
import pe.com.utp.service.support.discount.dto.BodyResponse;
import pe.com.utp.service.support.discount.dto.DiscountRequest;
import pe.com.utp.service.support.discount.exception.DBException;
import pe.com.utp.service.support.discount.model.Discount;
import pe.com.utp.service.support.discount.repository.DiscountRepository;

@Slf4j
@Service
public class DiscountServiceImpl implements DiscountService {

    private DiscountRepository repository;

    public DiscountServiceImpl(DiscountRepository repository) {
        this.repository = repository;
    }

    @Override
    public BodyResponse createDiscount(DiscountRequest request, String correlatorId) throws DBException {

        BodyResponse response = new BodyResponse();

        try {
            repository.save(setDiscountCreate(request, response));

            response.setIdTransaction(correlatorId);
            response.setCode("0");
            response.setMessage("Proceso exitoso");

        } catch (DataAccessException e) {
            throw new DBException("-1", "No se pudo registrar descuento en la base de datos 'quinta_categoria', [ERROR]: " + e.getMessage(), e);
        } catch (Exception e) {
            response.setIdTransaction(correlatorId);
            response.setCode("-2");
            response.setMessage("Ocurrió un error inesperado: " + e.getMessage());
        }

        return response;
    }


    public Discount setDiscountCreate(DiscountRequest request, BodyResponse response) {

        Discount discount = new Discount();

        discount.setD0001(request.getD0001());
        discount.setD0002(request.getD0002());
        discount.setD0004(request.getD0004());
        discount.setD0005(request.getD0005());
        discount.setD0006(request.getD0006());
        discount.setD0008(request.getD0008());
        discount.setD0009(request.getD0009());
        discount.setD0015(request.getD0015());
        discount.setD0021(request.getD0021());
        discount.setD0023(request.getD0023());
        discount.setD0026(request.getD0026());
        discount.setD0054(request.getD0054());
        discount.setD0109(request.getD0109());
        discount.setD0113(request.getD0113());
        discount.setD0115(request.getD0115());
        discount.setD0118(request.getD0118());
        discount.setD0121(request.getD0121());

        discount.setD0130(request.getD0130());
        discount.setD0139(request.getD0139());
        discount.setD0140(request.getD0140());
        discount.setD0143(request.getD0143());
        discount.setD0151(request.getD0151());
        discount.setD0190(request.getD0190());
        discount.setD0417(request.getD0417());
        discount.setD0418(request.getD0418());
        discount.setD0856(request.getD0856());
        discount.setD1010(request.getD1010());
        discount.setD1145(request.getD1145());
        discount.setD1146(request.getD1146());
        discount.setD1723(request.getD1723());
        discount.setD1763(request.getD1763());
        discount.setD1784(request.getD1784());
        discount.setD1819(request.getD1819());
        discount.setD1829(request.getD1829());
        discount.setIdPlanillaColaborador(Integer.valueOf(request.getIdPlanillaColaborador()));

        repository.save(discount);

        response.setIdRegistry(String.valueOf(discount.getIdDescuento()));

        return discount;
    }

}
