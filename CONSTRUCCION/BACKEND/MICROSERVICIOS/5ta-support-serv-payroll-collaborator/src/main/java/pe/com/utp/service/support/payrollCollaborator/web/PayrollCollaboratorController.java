package pe.com.utp.service.support.payrollCollaborator.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.com.utp.service.support.payrollCollaborator.business.PayrollCollaboratorService;
import pe.com.utp.service.support.payrollCollaborator.dto.BodyResponse;
import pe.com.utp.service.support.payrollCollaborator.dto.PayrollCollaboratorRequest;
import pe.com.utp.service.support.payrollCollaborator.exception.DBException;
import pe.com.utp.service.support.payrollCollaborator.util.PayrollCollaboratorUtil;

@RestController
@RequestMapping("/5ta-support-serv-payroll-collaborator/v1")
public class PayrollCollaboratorController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PayrollCollaboratorService payrollCollaboratorService;

    @PostMapping(value = "/createPayrollCollaborator", produces = {"application/json;charset=utf-8"})
    public ResponseEntity<BodyResponse> createPayrollCollaborator(
            @RequestHeader(value = "Authorization", required = true) String authorization,
            @RequestHeader(value = "correlatorId", required = false) String correlatorId,
            @RequestHeader(value = "messageId", required = false) String messageId,
            @RequestHeader(value = "requestDate", required = false) String requestDate,
            @RequestHeader(value = "originSystem", required = false) String originSystem,
            @RequestHeader(value = "targetSystem", required = false) String targetSystem,
            @RequestHeader(value = "country", required = false) String country,
            @RequestBody(required = true) PayrollCollaboratorRequest request) throws DBException {

        BodyResponse response = new BodyResponse();


        Map<String, Object> responseToken = PayrollCollaboratorUtil.validToken(authorization);

        Boolean estado = (Boolean) responseToken.get("estado");
        String rol = (String) responseToken.get("rol");


        try {
            if (estado) {
                if (rol.equals("Administrador")) {
                    response = payrollCollaboratorService.createPayrollCollaborator(request, correlatorId);
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

}
