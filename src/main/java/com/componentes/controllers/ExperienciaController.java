package com.componentes.controllers;

import com.componentes.contracts.ICrudController;
import com.componentes.entitys.ExperienciaLaboral;
import com.componentes.services.ExperienciaService;
import jakarta.persistence.EntityManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExperienciaController implements ICrudController<ExperienciaLaboral> {

    private EntityManager em = null;
    private ExperienciaService experienciaService;
    private List<ExperienciaLaboral> experiencias;
    private ExperienciaLaboral experiencia;

    public ExperienciaController() {
        this.experienciaService = new ExperienciaService();

        if (em == null) {
            em = PersistenceManager.getEntityManager("BackCompPU");
        }
    }

    @Override
    public boolean create(ExperienciaLaboral objeto) {
        try {
            this.experienciaService.insertar(em, objeto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ExperienciaLaboral read(int id) {
        try {
            experiencia = new ExperienciaLaboral();
            experiencia.setId(id);
            experiencia = this.experienciaService.encontrarPK(em, experiencia);
            return experiencia;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(ExperienciaLaboral objeto) {
        try {
            this.experienciaService.modificar(em, objeto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            experiencia = new ExperienciaLaboral();
            experiencia.setId(id);
            this.experienciaService.eliminar(em, experiencia);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ExperienciaLaboral> readAll() {
        experiencias = new ArrayList<>();

        try {
            experiencias = this.experienciaService.listar(em);
            return experiencias;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ExperienciaLaboral> readAllByUser(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
