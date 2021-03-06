package com.xoquin.centroestudios.dao;

public class DaoFactory {
    public DaoFactory() {
        super();
    }

    public AlumnoDAO getAlumnoDao(){
        return new AlumnoDAO();
    }

    public AsignaturaDAO getAsignaturaDAO(){
        return new AsignaturaDAO();
    }

    public ProfesorDAO getProfesorDAO(){
        return new ProfesorDAO();
    }

    public DepartamentoDAO getDepartamentoDAO(){
        return new DepartamentoDAO();
    }
}
