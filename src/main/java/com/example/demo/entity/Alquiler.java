package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_alquiler") // Nombre de la tabla en la base de datos
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alquiler_id") // Nombre de la columna de la clave primaria en la base de datos
    private Long alquilerId;

    @ManyToOne // Indica una relación Many-to-One con la entidad Cliente
    @JoinColumn(name = "cliente_id") // Nombre de la columna de clave foránea en la tabla alquiler
    private Cliente cliente;

    @ManyToOne // Indica una relación Many-to-One con la entidad Vehiculo
    @JoinColumn(name = "vehiculo_id") // Nombre de la columna de clave foránea en la tabla alquiler
    private Vehiculo vehiculo;

    @Column(name = "fecha_inicio") // Nombre de la columna en la base de datos para la fecha de inicio
    @Temporal(TemporalType.DATE) // Especifica el tipo de temporalidad para la fecha
    private Date fechaInicio;

    @Column(name = "fecha_fin") // Nombre de la columna en la base de datos para la fecha de fin
    @Temporal(TemporalType.DATE) // Especifica el tipo de temporalidad para la fecha
    private Date fechaFin;

    // Otros atributos y métodos getter/setter

}
