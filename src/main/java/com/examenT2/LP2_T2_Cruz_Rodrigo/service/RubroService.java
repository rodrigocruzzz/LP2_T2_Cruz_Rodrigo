package com.examenT2.LP2_T2_Cruz_Rodrigo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.LP2_T2_Cruz_Rodrigo.model.RubroCR;
import com.examenT2.LP2_T2_Cruz_Rodrigo.repository.RubroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RubroService {

    private final RubroRepository rubroRepository;
    

    
    public List<RubroCR> getAll() {
        return rubroRepository.findAll();
    }

}
