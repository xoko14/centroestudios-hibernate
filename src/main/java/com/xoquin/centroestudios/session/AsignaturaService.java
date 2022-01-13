package com.xoquin.centroestudios.session;

import java.util.List;

import com.xoquin.centroestudios.dao.AsignaturaDAO;
import com.xoquin.centroestudios.dao.DaoFactory;
import com.xoquin.centroestudios.model.Asignatura;

public class AsignaturaService implements Service<Asignatura>{
    private AsignaturaDAO asignaturaDao;
    private static SesionFactory sesionFactory;

    public AsignaturaService() {
        asignaturaDao = new DaoFactory().getAsignaturaDAO();
        sesionFactory = SesionFactory.getSesionFactory();
    }

    @Override
    public void persist(Asignatura entity){
        sesionFactory.openCurrentSessionwithTransaction();
        asignaturaDao.persist(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    @Override
    public void update(Asignatura entity){
        sesionFactory.openCurrentSessionwithTransaction();
        asignaturaDao.update(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    @Override
    public Asignatura findById(int id1) {
        sesionFactory.openCurrentSession();
        Asignatura entity = asignaturaDao.findById(id1, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSession();
        return entity;
    }

    @Override
    public void delete(Asignatura entity){
        sesionFactory.openCurrentSessionwithTransaction();
        asignaturaDao.delete(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<Asignatura> findAll() {
        sesionFactory.openCurrentSession();
        List<Asignatura> entities = asignaturaDao.findAll(sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSession();
        return entities;
    }

    @Override
    public void deleteAll(){
        sesionFactory.openCurrentSessionwithTransaction();
        asignaturaDao.deleteAll(sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }
}
