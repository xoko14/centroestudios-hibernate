package com.xoquin.centroestudios.session;

import java.util.List;

import com.xoquin.centroestudios.dao.AlumnoDAO;
import com.xoquin.centroestudios.dao.DaoFactory;
import com.xoquin.centroestudios.model.Alumno;

public class AlumnoService implements Service<Alumno>{
    private AlumnoDAO alumnoDao;
    private static SesionFactory sesionFactory;

    public AlumnoService() {
        alumnoDao = new DaoFactory().getAlumnoDao();
        sesionFactory = SesionFactory.getSesionFactory();
    }

    @Override
    public void persist(Alumno entity){
        sesionFactory.openCurrentSessionwithTransaction();
        alumnoDao.persist(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    @Override
    public void update(Alumno entity){
        sesionFactory.openCurrentSessionwithTransaction();
        alumnoDao.update(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    @Override
    public Alumno findById(int id1) {
        sesionFactory.openCurrentSession();
        Alumno alumno = alumnoDao.findById(id1, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSession();
        return alumno;
    }

    @Override
    public void delete(Alumno entity){
        sesionFactory.openCurrentSessionwithTransaction();
        alumnoDao.delete(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<Alumno> findAll() {
        sesionFactory.openCurrentSession();
        List<Alumno> alumnos = alumnoDao.findAll(sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSession();
        return alumnos;
    }

    @Override
    public void deleteAll(){
        sesionFactory.openCurrentSessionwithTransaction();
        alumnoDao.deleteAll(sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }
    
}
