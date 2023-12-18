package com.componentes.entitys;

import jakarta.persistence.*;
import java.util.List;
import com.componentes.enums.Puesto;
import java.io.Serializable;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Empleados extends Persona implements Serializable {

    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Puesto puesto;

    @Column(nullable = false)
    private String experiencia;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asignaciones> empleadoAsignaciones;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vacaciones> empleadoVacaciones;

    private static final long serialVersionUID = 1L;
}
