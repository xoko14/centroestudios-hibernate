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
        out.print(table);
        out.println(avisoContinuar);
        sc.nextLine();

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
}
