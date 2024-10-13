package pe.com.utp.service.uit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.com.utp.service.uit.business.UitService;
import pe.com.utp.service.uit.dto.UitResponse;

import java.io.IOException;

@RestController
@RequestMapping("/5ta-business-serv-uit/v1")
public class UitApiController implements UitApi {

    @Autowired
    UitService uitService;

/*    @Autowired
    PropertiesInternos propertiesInternos;*/

    private static Logger logger = LoggerFactory.getLogger(UitApiController.class);

    public ResponseEntity getUit(
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @RequestHeader(value = "correlatorId", required = false) String correlatorId,
            @RequestHeader(value = "messageId", required = false) String messageId,
            @RequestHeader(value = "requestDate", required = false) String requestDate,
            @RequestHeader(value = "originSystem", required = false) String originSystem,
            @RequestHeader(value = "targetSystem", required = false) String targetSystem,
            @RequestHeader(value = "country", required = false) String country){


        try {

            return new ResponseEntity<UitResponse>(uitService.getUit(), HttpStatus.OK);

        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error al obtener el valor de la UIT.");
        }


    }

}
