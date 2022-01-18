package com.xoquin.centroestudios.view;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class View {
    public static String menu = "MENU\n"+
                                "1) Mostrar todos los alumnos.\n"+
                                "2) Mostar un alumno en concreto.\n"+
                                "3) Mostar todas las asignaturas.\n"+
                                "4) Mostar una asignatura en concreto.\n"+
                                "5) Mostrar todos los profesores.\n"+
                                "6) Mostar un profesor en concreto.\n"+
                                "7) Mostrar todos los departamentos.\n"+
                                "8) Mostar un departamento en concreto.\n"+
                                "9) Buscar asignaturas por nombre.\n"+
                                "A) Añadir asignatura.\n"+
                                "B) Eliminar asignatura.\n"+
                                "0) Salir.\n";

    public static String avisoContinuar = "---PRESIONA ENTER PARA CONTINUAR---";
    
    public static String promptChar = ">";

    private Scanner sc;
    private PrintStream out;
    private InputStream in;

    public View(InputStream input, PrintStream output){
        in = input;
        out = output;
        sc = new Scanner(in);
    }

    public void printTable(Table<?> table){
        clear();
        out.print(table);
        out.println(avisoContinuar);
        sc.nextLine();
        clear();

    }

    public char menuAsk(){
        out.print(menu);
        out.print(promptChar);
        return sc.nextLine().toLowerCase().charAt(0);
    }

    public String askString(String question){
        out.println(question);
        out.print(promptChar);
        return sc.nextLine();
    }

    public int askInt(String question){
        boolean inputCorrect = false;
        int number;
        while(!inputCorrect){
            out.println(question);
            out.print("(número)"+promptChar);
            try{
                number = Integer.parseInt(sc.nextLine());
                inputCorrect = true;
                return number;
            }
            catch(NumberFormatException e){
                out.println("Por favor, introduce un número.");
            }
        }
        return 0;
    }

    public void showMessage(String message){
        out.println(message);
    }

    public void clear(){
        out.print("\033[H\033[2J");  
        out.flush();
    }
}
