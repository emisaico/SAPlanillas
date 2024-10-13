package com.utp.edu._ta_categoria.service;

import com.utp.edu._ta_categoria.entity.Boleta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoletaService {
    public Page<Boleta> listarBoletas(Pageable pageable);
}
