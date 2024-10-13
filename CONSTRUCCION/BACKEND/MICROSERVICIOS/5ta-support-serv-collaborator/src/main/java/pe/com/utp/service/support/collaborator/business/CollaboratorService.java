package pe.com.utp.service.support.collaborator.business;

import pe.com.utp.service.support.collaborator.dto.BodyResponse;
import pe.com.utp.service.support.collaborator.dto.CollaboratorRequest;
import pe.com.utp.service.support.collaborator.dto.CollaboratorResponse;
import pe.com.utp.service.support.collaborator.exception.DBException;


public interface CollaboratorService {

	public BodyResponse createCollaborator(CollaboratorRequest request, String correlatorId) throws DBException;

	public CollaboratorResponse retrieveCollaborator(String codigoModular) throws DBException;

}
