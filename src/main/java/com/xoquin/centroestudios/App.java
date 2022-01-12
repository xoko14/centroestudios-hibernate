package com.xoquin.centroestudios;

import com.xoquin.centroestudios.session.AlumnoService;
import com.xoquin.centroestudios.view.View;

/**
 * Hello world!
 *
 */
public class App 
{
    private static View view = new View(System.in, System.out);
    private static AlumnoService alumnoService = new AlumnoService();

    public static void main( String[] args )
    {
     boolean finished = false;

     while(!finished){
         switch(view.menuAsk()){
             case '1':
                view.printTableAlumno(alumnoService.findAll());
                break;
         }
     }
    }
}
