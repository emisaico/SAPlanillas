package pe.com.utp.service.support.payroll.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.com.utp.service.support.payroll.business.PayrollService;
import pe.com.utp.service.support.payroll.dto.BodyResponse;
import pe.com.utp.service.support.payroll.dto.PayrollRequest;
import pe.com.utp.service.support.payroll.exception.DBException;
import pe.com.utp.service.support.payroll.util.PayrollUtil;

@RestController
@RequestMapping("/5ta-support-serv-payroll/v1")
public class PayrollController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PayrollService payrollService;

    @PostMapping(value = "/createPayroll", produces = {"application/json;charset=utf-8"})
    public ResponseEntity<BodyResponse> createPayroll(
            @RequestHeader(value = "Authorization", required = true) String authorization,
            @RequestHeader(value = "correlatorId", required = false) String correlatorId,
            @RequestHeader(value = "messageId", required = false) String messageId,
            @RequestHeader(value = "requestDate", required = false) String requestDate,
            @RequestHeader(value = "originSystem", required = false) String originSystem,
            @RequestHeader(value = "targetSystem", required = false) String targetSystem,
            @RequestHeader(value = "country", required = false) String country,
            @RequestBody(required = true) PayrollRequest request) throws DBException {

        BodyResponse response = new BodyResponse();


        Map<String, Object> responseToken = PayrollUtil.validToken(authorization);

        Boolean estado = (Boolean) responseToken.get("estado");
        String rol = (String) responseToken.get("rol");


        try {
            if (estado) {
                if (rol.equals("Administrador")) {
                    response = payrollService.createPayroll(request, correlatorId);
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
