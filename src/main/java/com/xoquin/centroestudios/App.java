package com.xoquin.centroestudios;

import com.xoquin.centroestudios.model.Alumno;
import com.xoquin.centroestudios.model.Asignatura;
import com.xoquin.centroestudios.session.AlumnoService;
import com.xoquin.centroestudios.session.AsignaturaService;
import com.xoquin.centroestudios.view.Table;
import com.xoquin.centroestudios.view.View;

/**
 * Hello world!
 *
 */
public class App 
{
    private static View view = new View(System.in, System.out);
    private static AlumnoService alumnoService = new AlumnoService();
    private static AsignaturaService asignaturaService = new AsignaturaService();

    public static void main( String[] args )
    {
     boolean finished = false;
     int query;

     while(!finished){
         switch(view.menuAsk()){
            case '1':
                view.printTable(new Table<Alumno>(alumnoService.findAll()));
                break;

            case '2':
                query = view.askInt("Número de expediente de alumno");
                view.printTable(new Table<Alumno>(alumnoService.findById(query)));
                break;

            case '3':
                view.printTable(new Table<Asignatura>(asignaturaService.findAll()));
                break;

            case '4':
                query = view.askInt("ID de asignatura.");
                view.printTable(new Table<Asignatura>(asignaturaService.findById(query)));
                break;

            case '0':
                finished = true;
                break;

            default:
                view.showMessage("Opción no reconocida.");
         }
     }
    }
}
