package com.componentes.entitys;

import java.io.Serializable;
import java.sql.Date;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Asignaciones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleados empleado;

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyectos proyecto;

    @Column(nullable = false)
    private String tarea;

    private Date fechaInicio;
    private Date fechaFin;
    private static final long serialVersionUID = 1L;

}
