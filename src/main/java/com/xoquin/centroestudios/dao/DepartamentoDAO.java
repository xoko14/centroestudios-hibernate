package com.xoquin.centroestudios.dao;

import java.util.List;

import com.xoquin.centroestudios.model.Departamento;

import org.hibernate.Session;

public class DepartamentoDAO implements Dao<Departamento>{
    @Override
    public void persist(Departamento entity, Session session) {
        session.persist(entity);
    }

    @Override
    public void update(Departamento entity, Session session) {
        session.update(entity);
        
    }

    @Override
    public Departamento findById(int id, Session session) {
        return session.get(Departamento.class, id);
    }

    @Override
    public void delete(Departamento entity, Session session) {
        session.delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Departamento> findAll(Session session) {
        return (List<Departamento>) session.createQuery("from Departamento").list();
    }

    @Override
    public void deleteAll(Session session) {
        findAll(session).forEach(entity -> { delete(entity, session); });
        
    }  
}
