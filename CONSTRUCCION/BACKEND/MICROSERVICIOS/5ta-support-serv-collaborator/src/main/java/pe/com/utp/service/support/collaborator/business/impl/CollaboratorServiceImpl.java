package pe.com.utp.service.support.collaborator.business.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import pe.com.utp.service.support.collaborator.business.CollaboratorService;
import pe.com.utp.service.support.collaborator.dto.BodyResponse;
import pe.com.utp.service.support.collaborator.dto.CollaboratorRequest;
import pe.com.utp.service.support.collaborator.dto.CollaboratorResponse;
import pe.com.utp.service.support.collaborator.exception.DBException;
import pe.com.utp.service.support.collaborator.model.Collaborator;
import pe.com.utp.service.support.collaborator.repository.CollaboratorRepository;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
public class CollaboratorServiceImpl implements CollaboratorService {

    private CollaboratorRepository repository;

    public CollaboratorServiceImpl(CollaboratorRepository repository) {
        this.repository = repository;
    }

    @Override
    public BodyResponse createCollaborator(CollaboratorRequest request, String correlatorId) throws DBException {

        BodyResponse response = new BodyResponse();

        try {
            repository.save(setCollaboratorCreate(request, response));

            response.setIdTransaction(correlatorId);
            response.setCode("0");
            response.setMessage("Proceso exitoso");

        } catch (DataAccessException e) {
            throw new DBException("-1", "No se pudo registrar colaborador en la base de datos 'quinta_categoria', [ERROR]: " + e.getMessage(), e);
        } catch (Exception e) {
            response.setIdTransaction(correlatorId);
            response.setCode("-2");
            response.setMessage("Ocurrió un error inesperado: " + e.getMessage());
        }

        return response;
    }

    @Override
    public CollaboratorResponse retrieveCollaborator(String codigoModular) throws DBException {

        Collaborator collaborator = new Collaborator();

        try {
            collaborator = repository.findByCodigoModular(Long.valueOf(codigoModular)).orElseThrow(() -> new EntityNotFoundException("Colaborador no encontrado"));
        }catch (EntityNotFoundException e){
            throw new DBException("-1", "No se pudo encontrar colaborador en la base de datos 'quinta_categoria', [ERROR]: " + e.getMessage(), e);
        }

        return getCollaborator(collaborator);
    }


    public Collaborator setCollaboratorCreate(CollaboratorRequest request,  BodyResponse response) {

        Collaborator collaborator = new Collaborator();

        collaborator.setNombres(request.getNombres());
        collaborator.setApellidoPaterno(request.getApellidoPaterno());
        collaborator.setApellidoMaterno(request.getApellidoMaterno());
        collaborator.setNumeroDocumento(Integer.parseInt(request.getNumeroDocumento()));
        collaborator.setCodigoModular(Long.parseLong(request.getCodigoModular()));
        collaborator.setCodigoSecuencial(Long.parseLong(request.getCodigoSecuencial()));

        repository.save(collaborator);

        response.setIdRegistry(String.valueOf(collaborator.getIdColaborador()));

        return collaborator;
    }

    public CollaboratorResponse getCollaborator(Collaborator collaborator) {

        CollaboratorResponse response = new CollaboratorResponse();

        response.setIdColaborador(String.valueOf(collaborator.getIdColaborador()));
        response.setNombres(collaborator.getNombres());
        response.setApellidoPaterno(collaborator.getApellidoPaterno());
        response.setApellidoMaterno(collaborator.getApellidoMaterno());
        response.setNumeroDocumento(String.valueOf(collaborator.getNumeroDocumento()));
        response.setCodigoModular(String.valueOf(collaborator.getCodigoModular()));
        response.setCodigoSecuencial(String.valueOf(collaborator.getCodigoSecuencial()));

        return response;
    }

}
