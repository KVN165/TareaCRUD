/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.tareacrud;

import java.util.Scanner;

/**
 *
 * @author KVN
 */
public class Funciones {
    
    
    public static void separador(){
        System.out.println(new String(new char[80]).replace("\0","-"));
    }
    
    public static void print(String text){
        System.out.println(text);
    }
    public static void encabezado(String text){
        separador();
        print(text);
        separador();   
    }
    
    public static void menu(){
        System.out.println("\n\n\n");
        System.out.println("*********************************");
        System.out.println("Bienvenido al sistema de agendas");
        System.out.println("Selecione una opción del programa");
        System.out.println("*********************************");
        System.out.println("1- Agregar un contacto");
        System.out.println("2- Mostrar todos los contactos");
        System.out.println("3- Actualizar un contacto");
        System.out.println("4- Eliminar un contacto");
        System.out.println("5- Salir del programa");
        System.out.println("*********************************");      
}
    
    public static void printEncabezadoTabla(){
        separador();
        print(String.format("%s\t%s\t%s\t%s\t%s", "ID", "NOMBRE", "DESCRIPCION", "NUMERO", "EDAD"));
        separador();
    }
    
    public static String capturarCampo(Scanner entradaTeclado, String leyenda, String valorPredeterminado){
        print(leyenda + "(" +valorPredeterminado+ ") :");
        
        String input = entradaTeclado.nextLine();

        if(input.isEmpty()){
            return valorPredeterminado;
        }
        return input;
    }
}
