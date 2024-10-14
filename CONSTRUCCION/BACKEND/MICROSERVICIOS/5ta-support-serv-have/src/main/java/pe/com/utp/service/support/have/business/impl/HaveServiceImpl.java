package pe.com.utp.service.support.have.business.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.utp.service.support.have.business.HaveService;
import pe.com.utp.service.support.have.dto.BodyResponse;
import pe.com.utp.service.support.have.dto.HaveRequest;
import pe.com.utp.service.support.have.exception.DBException;
import pe.com.utp.service.support.have.model.Have;
import pe.com.utp.service.support.have.repository.HaveRepository;

@Slf4j
@Service
public class HaveServiceImpl implements HaveService {

    private HaveRepository repository;

    public HaveServiceImpl(HaveRepository repository) {
        this.repository = repository;
    }

    @Override
    public BodyResponse createHave(HaveRequest request, String correlatorId) throws DBException {

        BodyResponse response = new BodyResponse();

        try {
            repository.save(setHaveCreate(request, response));

            response.setIdTransaction(correlatorId);
            response.setCode("0");
            response.setMessage("Proceso exitoso");

        } catch (DataAccessException e) {
            throw new DBException("-1", "No se pudo registrar haber en la base de datos 'quinta_categoria', [ERROR]: " + e.getMessage(), e);
        } catch (Exception e) {
            response.setIdTransaction(correlatorId);
            response.setCode("-2");
            response.setMessage("Ocurrió un error inesperado: " + e.getMessage());
        }

        return response;
    }


    public Have setHaveCreate(HaveRequest request, BodyResponse response) {

        Have have = new Have();

        have.setH001(request.getH001());
        have.setH002(request.getH002());
        have.setH003(request.getH003());
        have.setH004(request.getH004());
        have.setH006(request.getH006());
        have.setH008(request.getH008());
        have.setH009(request.getH009());
        have.setH010(request.getH010());
        have.setH012(request.getH012());
        have.setH014(request.getH014());
        have.setH017(request.getH017());
        have.setH023(request.getH023());
        have.setH024(request.getH024());
        have.setH025(request.getH025());
        have.setH026(request.getH026());
        have.setH033(request.getH033());
        have.setH079(request.getH079());
        have.setH080(request.getH080());
        have.setH082(request.getH082());
        have.setH090(request.getH090());
        have.setH092(request.getH092());
        have.setH099(request.getH099());
        have.setH100(request.getH100());
        have.setH136(request.getH136());
        have.setH150(request.getH150());
        have.setH162(request.getH162());
        have.setH170(request.getH170());
        have.setH177(request.getH177());
        have.setH178(request.getH178());
        have.setH181(request.getH181());
        have.setH185(request.getH185());
        have.setH206(request.getH206());
        have.setH231(request.getH231());
        have.setH244(request.getH244());
        have.setH259(request.getH259());
        have.setH261(request.getH261());
        have.setH263(request.getH263());
        have.setH264(request.getH264());
        have.setH271(request.getH271());
        have.setH277(request.getH277());
        have.setH288(request.getH288());
        have.setH303(request.getH303());
        have.setH309(request.getH309());
        have.setH310(request.getH310());

        have.setIdPlanillaColaborador(Integer.valueOf(request.getIdPlanillaColaborador()));

        repository.save(have);

        response.setIdRegistry(String.valueOf(have.getIdHaber()));

        return have;
    }

}
