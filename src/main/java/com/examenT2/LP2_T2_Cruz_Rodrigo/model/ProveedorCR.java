package com.examenT2.LP2_T2_Cruz_Rodrigo.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name = "tbl_proveedor")
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProveedorCR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "pagina_web")
    private String paginaWeb;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rubro")
    private RubroCR rubro;
}
