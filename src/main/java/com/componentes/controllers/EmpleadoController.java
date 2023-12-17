package com.componentes.controllers;

import com.componentes.contracts.ICrudController;
import com.componentes.entitys.Empleados;
import com.componentes.services.EmpleadoService;
import jakarta.persistence.EntityManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoController implements ICrudController<Empleados> {

    private EntityManager em = null;
    private EmpleadoService empleadoService;
    private List<Empleados> empleados;
    private Empleados empleado;

    public EmpleadoController() {

        this.empleadoService = new EmpleadoService();

        if (em == null) {
            em = PersistenceManager.getEntityManager("BackCompPU");
        }
    }

    @Override
    public boolean create(Empleados objeto) {
        try {
            this.empleadoService.insertar(em, objeto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Empleados read(int id) {
        try {
            empleado = new Empleados();
            empleado.setId(id);
            empleado = this.empleadoService.encontrarPK(em, empleado);
            return empleado;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Empleados objeto) {
        try {
            this.empleadoService.modificar(em, objeto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            empleado = new Empleados();
            empleado.setId(id);
            this.empleadoService.eliminar(em, empleado);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Empleados> readAll() {
        empleados = new ArrayList<>();

        try {
            empleados = this.empleadoService.listar(em);
            return empleados;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Empleados> readAllByUser(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
