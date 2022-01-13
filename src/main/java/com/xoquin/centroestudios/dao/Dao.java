package com.xoquin.centroestudios.dao;

import java.util.List;

import org.hibernate.Session;

public interface Dao<T> {

    public void persist(T entity, Session session);

    public void update(T entity, Session session);

    public T findById(int id, Session session);

    public void delete(T entity, Session session);

    public List<T> findAll(Session session);

    public void deleteAll(Session sesion);
}

