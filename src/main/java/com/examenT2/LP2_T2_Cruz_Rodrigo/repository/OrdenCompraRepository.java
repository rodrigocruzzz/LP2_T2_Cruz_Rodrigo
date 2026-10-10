package com.examenT2.LP2_T2_Cruz_Rodrigo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenT2.LP2_T2_Cruz_Rodrigo.model.OrdenCompraCR;

public interface OrdenCompraRepository
        extends JpaRepository<OrdenCompraCR, Integer> {

    List<OrdenCompraCR> findAllByOrderByNroOrdenDesc();

}