package com.componentes.entitys;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String texto;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyectos proyecto;
    private static final long serialVersionUID = 1L;

}
