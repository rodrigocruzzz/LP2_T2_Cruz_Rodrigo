package com.examenT2.LP2_T2_Cruz_Rodrigo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.LP2_T2_Cruz_Rodrigo.dto.ResultadoResponse;
import com.examenT2.LP2_T2_Cruz_Rodrigo.model.OrdenCompraCR;
import com.examenT2.LP2_T2_Cruz_Rodrigo.repository.OrdenCompraRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenCompraService {
	
    private final OrdenCompraRepository ordenCompraRepository;
    


    public List<OrdenCompraCR> getAll() {
        return ordenCompraRepository
                .findAllByOrderByNroOrdenDesc();
    }

    public OrdenCompraCR getOne(Integer id) {
        return ordenCompraRepository.findById(id).orElse(null);
    }

    @Transactional
    public ResultadoResponse create(OrdenCompraCR ordenCompra) {
        try {
            var registrado = ordenCompraRepository.save(ordenCompra);

            var mensaje = String.format(
                    "Orden de compra Nro. %d registrada",
                    registrado.getNroOrden()
            );

            return new ResultadoResponse(true, mensaje);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResultadoResponse(
                    false, "Hubo un error en la transacción"
            );
        }
    }

    @Transactional
    public ResultadoResponse update(OrdenCompraCR ordenCompra) {
        try {
            var actualizado = ordenCompraRepository.save(ordenCompra);

            var mensaje = String.format(
                    "Orden de compra Nro. %d actualizada",
                    actualizado.getNroOrden()
            );

            return new ResultadoResponse(true, mensaje);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResultadoResponse(
                    false, "Hubo un error en la transacción"
            );
        }
    }
}
