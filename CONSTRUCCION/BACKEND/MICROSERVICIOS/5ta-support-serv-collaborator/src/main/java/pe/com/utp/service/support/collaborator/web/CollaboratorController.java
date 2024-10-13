package pe.com.utp.service.support.collaborator.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.com.utp.service.support.collaborator.business.CollaboratorService;
import pe.com.utp.service.support.collaborator.dto.BodyResponse;
import pe.com.utp.service.support.collaborator.dto.CollaboratorRequest;
import pe.com.utp.service.support.collaborator.dto.CollaboratorResponse;
import pe.com.utp.service.support.collaborator.exception.BaseException;
import pe.com.utp.service.support.collaborator.exception.DBException;
import pe.com.utp.service.support.collaborator.util.PlanillaUtil;

import javax.ws.rs.QueryParam;

@RestController
@RequestMapping("/5ta-support-serv-collaborator/v1")
public class CollaboratorController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CollaboratorService collaboratorService;

    @PostMapping(value = "/createCollaborator", produces = {"application/json;charset=utf-8"})
    public ResponseEntity<BodyResponse> createCollaborator(
            @RequestHeader(value = "Authorization", required = true) String authorization,
            @RequestHeader(value = "correlatorId", required = false) String correlatorId,
            @RequestHeader(value = "messageId", required = false) String messageId,
            @RequestHeader(value = "requestDate", required = false) String requestDate,
            @RequestHeader(value = "originSystem", required = false) String originSystem,
            @RequestHeader(value = "targetSystem", required = false) String targetSystem,
            @RequestHeader(value = "country", required = false) String country,
            @RequestBody(required = true) CollaboratorRequest request) throws DBException {

        BodyResponse response = new BodyResponse();
        System.out.println("authorization: " + authorization);


        Map<String, Object> responseToken = PlanillaUtil.validToken(authorization);

        Boolean estado = (Boolean) responseToken.get("estado");
        String rol = (String) responseToken.get("rol");


        try {
            if (estado) {
                if (rol.equals("Administrador")) {
                    response = collaboratorService.createCollaborator(request, correlatorId);
                    return new ResponseEntity<>(response, HttpStatus.OK);
                } else {
                    response.setIdTransaction(correlatorId);
                    response.setCode("2");
                    response.setMessage("Tu rol no tiene acceso a este servicio");
                }
            } else {
                response.setIdTransaction(correlatorId);
                response.setCode("1");
                response.setMessage((String) responseToken.get("mensaje"));
            }

        } catch (DBException e) {
            response.setIdTransaction(correlatorId);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());

            return new ResponseEntity<BodyResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<BodyResponse>(response, HttpStatus.UNAUTHORIZED);

    }

    @GetMapping(value = "/retrieveCollaborator", produces = {"application/json;charset=utf-8"})
    public ResponseEntity retrieveCollaborator(
            @RequestHeader(value = "Authorization", required = true) String authorization,
            @RequestHeader(value = "correlatorId", required = false) String correlatorId,
            @RequestHeader(value = "messageId", required = false) String messageId,
            @RequestHeader(value = "requestDate", required = false) String requestDate,
            @RequestHeader(value = "originSystem", required = false) String originSystem,
            @RequestHeader(value = "targetSystem", required = false) String targetSystem,
            @RequestHeader(value = "country", required = false) String country,
            @RequestParam(value = "codigoModular", required = true) String codigoModular) throws DBException {

        System.out.println("ENTRANDO CONTROLLER");

        CollaboratorResponse response = new CollaboratorResponse();
        BodyResponse bodyResponse = new BodyResponse();

        Map<String, Object> responseToken = PlanillaUtil.validToken(authorization);

        Boolean estado = (Boolean) responseToken.get("estado");
        String rol = (String) responseToken.get("rol");


        try {
            if (estado) {
                if (rol.equals("Administrador")) {
                    response = collaboratorService.retrieveCollaborator(codigoModular);
                    return new ResponseEntity<CollaboratorResponse>(response, HttpStatus.OK);
                } else {
                    bodyResponse.setIdTransaction(correlatorId);
                    bodyResponse.setCode("2");
                    bodyResponse.setMessage("Tu rol no tiene acceso a este servicio");
                }
            } else {
                bodyResponse.setIdTransaction(correlatorId);
                bodyResponse.setCode("1");
                bodyResponse.setMessage((String) responseToken.get("mensaje"));
            }

        } catch (DBException e) {
            bodyResponse.setIdTransaction(correlatorId);
            bodyResponse.setCode(e.getCode());
            bodyResponse.setMessage(e.getMessage());
            return new ResponseEntity<BodyResponse>(bodyResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<BodyResponse>(bodyResponse, HttpStatus.UNAUTHORIZED);

    }

}
