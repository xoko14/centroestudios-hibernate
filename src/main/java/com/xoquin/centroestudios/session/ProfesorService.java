package com.xoquin.centroestudios.session;

import java.util.List;

import com.xoquin.centroestudios.dao.DaoFactory;
import com.xoquin.centroestudios.dao.ProfesorDAO;
import com.xoquin.centroestudios.model.Profesor;

public class ProfesorService implements Service<Profesor>{
    private ProfesorDAO profesorDao;
    private static SesionFactory sesionFactory;

    public ProfesorService() {
        profesorDao = new DaoFactory().getProfesorDAO();
        sesionFactory = SesionFactory.getSesionFactory();
    }

    @Override
    public void persist(Profesor entity){
        sesionFactory.openCurrentSessionwithTransaction();
        profesorDao.persist(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    @Override
    public void update(Profesor entity){
        sesionFactory.openCurrentSessionwithTransaction();
        profesorDao.update(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    @Override
    public Profesor findById(int id1) {
        sesionFactory.openCurrentSession();
        Profesor entity = profesorDao.findById(id1, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSession();
        return entity;
    }

    @Override
    public void delete(Profesor entity){
        sesionFactory.openCurrentSessionwithTransaction();
        profesorDao.delete(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<Profesor> findAll() {
        sesionFactory.openCurrentSession();
        List<Profesor> entities = profesorDao.findAll(sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSession();
        return entities;
    }

    @Override
    public void deleteAll(){
        sesionFactory.openCurrentSessionwithTransaction();
        profesorDao.deleteAll(sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }
}
