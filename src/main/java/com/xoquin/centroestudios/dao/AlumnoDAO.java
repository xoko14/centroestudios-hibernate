package com.xoquin.centroestudios.dao;

import java.util.List;

import com.xoquin.centroestudios.model.Alumno;

import org.hibernate.Session;

public class AlumnoDAO implements Dao<Alumno>{
    public static Class<Alumno> alclass = Alumno.class;

    @Override
    public void persist(Alumno entity, Session session) {
        session.persist(entity);
    }

    @Override
    public void update(Alumno entity, Session session) {
        session.update(entity);
        
    }

    @Override
    public Alumno findById(int id, Session session) {
        return session.get(Alumno.class, id);
    }

    @Override
    public void delete(Alumno entity, Session session) {
        session.delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Alumno> findAll(Session session) {
        return (List<Alumno>) session.createQuery("from Alumno").list();
    }

    @Override
    public void deleteAll(Session session) {
        findAll(session).forEach(alumno -> { delete(alumno, session); });
        
    }

    @Override
    public Class<Alumno> getObjectClass() {
        return alclass;
    }
    
}
