package com.examenT2.LP2_T2_Cruz_Rodrigo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.LP2_T2_Cruz_Rodrigo.model.ProveedorCR;
import com.examenT2.LP2_T2_Cruz_Rodrigo.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;
    
    
    public List<ProveedorCR> getAll() {
        return proveedorRepository.findAll();
    }

}
