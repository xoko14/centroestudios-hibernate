package com.xoquin.centroestudios.dao;

import java.util.List;

import com.xoquin.centroestudios.model.Profesor;

import org.hibernate.Session;

public class ProfesorDAO implements Dao<Profesor>{

    @Override
    public void persist(Profesor entity, Session session) {
        session.persist(entity);
    }

    @Override
    public void update(Profesor entity, Session session) {
        session.update(entity);
        
    }

    @Override
    public Profesor findById(int id, Session session) {
        return session.get(Profesor.class, id);
    }

    @Override
    public void delete(Profesor entity, Session session) {
        session.delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profesor> findAll(Session session) {
        return (List<Profesor>) session.createQuery("from Profesor").list();
    }

    @Override
    public void deleteAll(Session session) {
        findAll(session).forEach(entity -> { delete(entity, session); });
        
    }  
    
}
