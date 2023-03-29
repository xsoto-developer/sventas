package com.sventas.sventas.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ventas")
@Data
@NoArgsConstructor
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_cliente", nullable = false, length = 5)
    private Integer idCliente;
    @Column(name = "detalle", nullable = true, length = 50)
    private String detalle;
    @Column(name = "cantidad", nullable = true, length = 10)
    private Integer cantidad;
    @Column(name = "sub_total", nullable = true, length = 10)
    private Double subTotal;
    @Column(name = "iva", nullable = true, length = 10)
    private Double iva;
    @Column(name = "total", nullable = true, length = 10)
    private Double total;
}
