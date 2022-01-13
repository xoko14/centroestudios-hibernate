package com.xoquin.centroestudios.session;

import java.util.List;

import com.xoquin.centroestudios.dao.DaoFactory;
import com.xoquin.centroestudios.dao.DepartamentoDAO;
import com.xoquin.centroestudios.model.Departamento;

public class DepartamentoService implements Service<Departamento>{
    private DepartamentoDAO departamentoDao;
    private static SesionFactory sesionFactory;

    public DepartamentoService() {
        departamentoDao = new DaoFactory().getDepartamentoDAO();
        sesionFactory = SesionFactory.getSesionFactory();
    }

    @Override
    public void persist(Departamento entity){
        sesionFactory.openCurrentSessionwithTransaction();
        departamentoDao.persist(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    @Override
    public void update(Departamento entity){
        sesionFactory.openCurrentSessionwithTransaction();
        departamentoDao.update(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    @Override
    public Departamento findById(int id1) {
        sesionFactory.openCurrentSession();
        Departamento entity = departamentoDao.findById(id1, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSession();
        return entity;
    }

    @Override
    public void delete(Departamento entity){
        sesionFactory.openCurrentSessionwithTransaction();
        departamentoDao.delete(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<Departamento> findAll() {
        sesionFactory.openCurrentSession();
        List<Departamento> entities = departamentoDao.findAll(sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSession();
        return entities;
    }

    @Override
    public void deleteAll(){
        sesionFactory.openCurrentSessionwithTransaction();
        departamentoDao.deleteAll(sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }
}
