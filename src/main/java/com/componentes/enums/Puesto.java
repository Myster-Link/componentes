package com.componentes.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Puesto {
    GERENTE("Gerente"),
    ANALISTA("Analista"),
    DESARROLLADOR("Desarrollador"),
    TESTER("Tester");

    private final String descripcion;
}
