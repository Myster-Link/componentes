package com.componentes.backcompo;

import com.componentes.controllers.*;
import com.componentes.entitys.*;
import com.componentes.enums.Puesto;
import java.util.List;

public class BackCompo {

    public static void main(String[] args) {
        try {
            EmpleadoController controller = new EmpleadoController();

            Usuarios usuario = new Usuarios();
            usuario.setId(1);

            Empleados empleado = new Empleados();
            empleado.setCedula(118800102);
            empleado.setDireccion("asfasfas");
            empleado.setSexo('M');
            empleado.setNombre("sassa");
            empleado.setPuesto(Puesto.ANALISTA);
            //empleado.setUsuario(usuario);

            //boolean result = controller.create(empleado);

            for (Empleados e : controller.readAll()) {
                System.out.println("Empleado: " + e.getNombre());
            }

            PersistenceManager.closeEntityManagerFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
