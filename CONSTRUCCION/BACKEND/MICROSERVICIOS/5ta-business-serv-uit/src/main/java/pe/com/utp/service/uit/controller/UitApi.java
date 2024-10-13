package pe.com.utp.service.uit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import pe.com.utp.service.uit.exception.ServiceException;

@Validated
public interface UitApi {

    @GetMapping(value = "/getUit", produces = {"application/json;charset=utf-8"})
    ResponseEntity getUit(
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @RequestHeader(value = "correlatorId", required = false) String correlatorId,
            @RequestHeader(value = "messageId", required = false) String messageId,
            @RequestHeader(value = "requestDate", required = false) String requestDate,
            @RequestHeader(value = "originSystem", required = false) String originSystem,
            @RequestHeader(value = "targetSystem", required = false) String targetSystem,
            @RequestHeader(value = "country", required = false) String country);


}
