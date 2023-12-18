package com.componentes.backcompo;

import com.componentes.controllers.*;
import com.componentes.entitys.*;

public class BackCompo {

    public static void main(String[] args) {
        try {

            AuthController authController = new AuthController();
            Usuarios usuarios = new Usuarios();
            usuarios.setCedula(118800102);
            usuarios.setNombre("Christopher");
            usuarios.setCorreo("sasa");
            usuarios.setDireccion("afgafas");
            usuarios.setSexo("Hombre ");
            usuarios.setClave("123");

            authController.register(usuarios);

            PersistenceManager.closeEntityManagerFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
