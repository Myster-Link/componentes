package com.componentes.controllers;

import com.componentes.contracts.ICrudController;
import com.componentes.entitys.Proyectos;
import com.componentes.services.ProyectoService;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ProyectoController implements ICrudController<Proyectos> {

    private EntityManager em = null;
    private ProyectoService proyectoService;
    private List<Proyectos> listProyectos;
    private Proyectos proyecto;

    public ProyectoController() {
        this.proyectoService = new ProyectoService();

        if (em == null) {
            em = PersistenceManager.getEntityManager("BackCompPU");
        }
    }

    @Override
    public boolean create(Proyectos objeto) {
        try {
            this.proyectoService.insertar(em, objeto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Proyectos read(int id) {
        try {
            proyecto = new Proyectos();
            proyecto.setId(id);
            proyecto = this.proyectoService.encontrarPK(em, proyecto);
            return proyecto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Proyectos objeto) {
        try {
            this.proyectoService.modificar(em, objeto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            proyecto = new Proyectos();
            proyecto.setId(id);
            this.proyectoService.eliminar(em, proyecto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Proyectos> readAll() {
        listProyectos = new ArrayList<>();

        try {
            listProyectos = this.proyectoService.listar(em);
            return listProyectos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Proyectos> readAllByUser(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
