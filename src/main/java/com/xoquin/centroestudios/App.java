package com.xoquin.centroestudios;

import com.xoquin.centroestudios.model.Alumno;
import com.xoquin.centroestudios.model.Asignatura;
import com.xoquin.centroestudios.model.Departamento;
import com.xoquin.centroestudios.model.Profesor;
import com.xoquin.centroestudios.session.AlumnoService;
import com.xoquin.centroestudios.session.AsignaturaService;
import com.xoquin.centroestudios.session.DepartamentoService;
import com.xoquin.centroestudios.session.ProfesorService;
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
    private static ProfesorService profesorService = new ProfesorService();
    private static DepartamentoService departamentoService = new DepartamentoService();

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
                query = view.askInt("ID de asignatura");
                view.printTable(new Table<Asignatura>(asignaturaService.findById(query)));
                break;

            case '5':
                view.printTable(new Table<Profesor>(profesorService.findAll()));
                break;

            case '6':
                query = view.askInt("ID de profesor");
                view.printTable(new Table<Profesor>(profesorService.findById(query)));
                break;

            case '7':
                view.printTable(new Table<Departamento>(departamentoService.findAll()));
                break;

            case '8':
                query = view.askInt("ID de departamento");
                view.printTable(new Table<Departamento>(departamentoService.findById(query)));
                break;

            case '9':
                String search = view.askString("Término de búsqueda");
                view.printTable(new Table<Asignatura>(asignaturaService.searchByName(search)));

            case '0':
                finished = true;
                break;

            default:
                view.showMessage("Opción no reconocida.");
         }
     }
    }
}
