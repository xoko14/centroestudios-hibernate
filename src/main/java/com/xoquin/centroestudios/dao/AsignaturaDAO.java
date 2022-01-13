package com.xoquin.centroestudios.dao;

import java.util.List;

import javax.persistence.Query;

import com.xoquin.centroestudios.model.Asignatura;

import org.hibernate.Session;

public class AsignaturaDAO implements Dao<Asignatura>{
    @Override
    public void persist(Asignatura entity, Session session) {
        session.persist(entity);
    }

    @Override
    public void update(Asignatura entity, Session session) {
        session.update(entity);
        
    }

    @Override
    public Asignatura findById(int id, Session session) {
        return session.get(Asignatura.class, id);
    }

    @Override
    public void delete(Asignatura entity, Session session) {
        session.delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Asignatura> findAll(Session session) {
        return (List<Asignatura>) session.createQuery("from Asignatura").list();
    }

    @Override
    public void deleteAll(Session session) {
        findAll(session).forEach(entity -> { delete(entity, session); });
        
    }
    
    @SuppressWarnings("unchecked")
    public List<Asignatura> searchByName(String s, Session session){
        Query q = session.createQuery("from Asignatura where lower(nombre) like :regex");
        q.setParameter("regex", "%"+s+"%");
        return q.getResultList();
    }
}
