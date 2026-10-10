package com.examenT2.LP2_T2_Cruz_Rodrigo.model;

import java.math.BigDecimal;
import java.sql.Date;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "OrdenCompra")
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrdenCompraCR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_orden")
    private Integer nroOrden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proveedor")
    private ProveedorCR proveedor;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "direccion_entrega")
    private String direccionEntrega;

    @Column(name = "fecha_entrega")
    private Date fechaEntrega;

    @Column(name = "estado")
    private String estado;
}
