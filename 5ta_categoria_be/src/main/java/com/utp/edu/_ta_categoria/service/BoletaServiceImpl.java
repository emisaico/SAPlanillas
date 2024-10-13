package com.utp.edu._ta_categoria.service;

import com.utp.edu._ta_categoria.entity.Boleta;
import com.utp.edu._ta_categoria.repository.BoletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoletaServiceImpl implements BoletaService {


    @Autowired
    private BoletaRepository boletaRepository;


    @Override
    public Page<Boleta> listarBoletas( Pageable pageable) {

        Page<Boleta> listaBoletas = boletaRepository.findAll(pageable);
        if(listaBoletas.isEmpty()){
            return null;
        }
        return listaBoletas;
    }
}
