package com.componentes.entitys;

import jakarta.persistence.*;

import com.componentes.enums.Puesto;
import java.io.Serializable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Empleados extends Persona implements Serializable {

    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Puesto puesto;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    private static final long serialVersionUID = 1L;
}
