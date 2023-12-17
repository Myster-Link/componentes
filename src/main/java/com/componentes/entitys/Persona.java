package com.componentes.entitys;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private char sexo;
    private String direccion;
    
    @Column(unique = true, nullable = false)
    private Integer cedula;

    private static final long serialVersionUID = 1L;
}
