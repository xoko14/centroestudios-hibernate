package com.xoquin.centroestudios.view;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import com.xoquin.centroestudios.model.Alumno;

public class View {
    public static String menu = "MENU\n"+
                                "1) Mostrar todos los alumnos.\n"+
                                "2) Mostar un alumno en concreto.\n";
    
    public static String promptChar = ">";

    private Scanner sc;
    private PrintStream out;

    public View(InputStream input, PrintStream output){
        sc = new Scanner(input);
        out = output;
    }

    public void printTableAlumno(Alumno obj){
        Table<Alumno> table = new Table<>(obj);
        out.print(table);
    }

    public void printTableAlumno(List<Alumno> objs){
        Table<Alumno> table = new Table<>(objs);
        out.print(table);
    }

    public char menuAsk(){
        out.print(menu);
        out.print(promptChar);
        return sc.nextLine().charAt(0);
    }

    public String askString(String question){
        out.println(question);
        out.print(promptChar);
        return sc.nextLine();
    }
}
