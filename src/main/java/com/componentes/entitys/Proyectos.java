package com.componentes.entitys;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Proyectos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_proyecto")
    private String nombreProyecto;

    @ManyToOne
    @JoinColumn(name = "empleado_lider_id")
    private Empleados liderProyecto;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asignaciones> asignaciones;

    // Otros atributos y métodos
    private static final long serialVersionUID = 1L;
}
