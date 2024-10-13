package com.utp.edu._ta_categoria.controller;

import com.utp.edu._ta_categoria.entity.Boleta;
import com.utp.edu._ta_categoria.request.PageableRequest;
import com.utp.edu._ta_categoria.service.BoletaService;
import com.utp.edu._ta_categoria.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constantes.BASEPATH+Constantes.PATH_BOLETA)
public class BoletaController {

    @Autowired
    private BoletaService boletaService;


    @PostMapping(value = "/listarBoletas")
    public ResponseEntity<Page<Boleta>> listaBoletas(
            @RequestBody PageableRequest request) {
        Page<Boleta> boletas = null;
        Pageable pageable = null;
        Sort.Direction asc = null;

        String tipoOrden = request.getTypeOrder();
        asc = Sort.Direction.valueOf(tipoOrden);
        System.out.println("asdsadsa");
        System.out.println();
        try{
            pageable = PageRequest.of(request.getPage(), request.getSize(), Sort.by(asc, request.getOrderParameter()));
            boletas = boletaService.listarBoletas(pageable);
            return (boletas != null) ? new ResponseEntity<>(boletas, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            System.out.println("Message: "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
