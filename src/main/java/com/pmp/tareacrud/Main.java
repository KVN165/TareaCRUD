/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.tareacrud;

import java.util.ArrayList;
import java.util.Scanner;
import com.pmp.dao.Contacto;
import com.pmp.dao.ContactosModel;
/**
 *
 * @author KVN
 */
public class Main {
    private static Scanner entradaTeclado = new Scanner(System.in);;
    private static ContactosModel model = new ContactosModel();
    public static void main(String[] args){
        System.out.println("*********************************");
        Funciones.menu();
        int opcion_menu=0;
        opcion_menu = entradaTeclado.nextInt();
        while (opcion_menu != 5){
            switch (opcion_menu){
                case 1:
                    Funciones.print("---Agregando un contacto---");
                    insertarContacto();
                    break;
                case 2:
                    Funciones.print("---Mostrar los contactos---");
                    mostrarListado();
                    break;
                case 3:
                    Funciones.print("---Actualizando un contacto---");
                    actualizarContacto();
                    break;
                case 4:
                    Funciones.print("---Eliminando un contacto---");
                    eliminarContacto();
                    break;
                case 5:
                    Funciones.print("---SALIENDO DEL PROGRAMA---");
                    break;
                default:
                    Funciones.menu();
                    Funciones.print("ERROR!!! agrege un numero válido (1-5)");
            }
            Funciones.menu();
            opcion_menu = entradaTeclado.nextInt();
        }
    }
    
    private static void mostrarListado(){
        Funciones.printEncabezadoTabla();
        ArrayList<Contacto> contactos = model.obtenerContactos();
        for (int i=0;i<contactos.size();i++){
            Funciones.print(contactos.get(i).getRow());
            Funciones.separador();
        }
    }
    
    private static void actualizarContacto(){
        Contacto updateContactos = new Contacto();
        int id;
        updateContactos.setId(Integer.parseInt(Funciones.capturarCampo(entradaTeclado, "Id", "1")));
        updateContactos = model.obtenerContacto(updateContactos.getId());
        updateContactos.setNombre(Funciones.capturarCampo(entradaTeclado, "nombre", ""));
        updateContactos.setDescripcion(Funciones.capturarCampo(entradaTeclado, "Descripcion", ""));
        updateContactos.setNumero(Integer.parseInt(Funciones.capturarCampo(entradaTeclado, "Numero", "")));
        updateContactos.setEdad(Integer.parseInt(Funciones.capturarCampo(entradaTeclado, "Edad", "")));
        int actualizar = model.actualizarContacto(updateContactos);
        if (actualizar > 0){
            Funciones.print("CONTACTO ACTUALIZADO!!!");
        }
        Funciones.separador();
    }
    
    private static void eliminarContacto(){
        
        Contacto deletContacto = new Contacto();
        deletContacto.setId(Integer.parseInt(Funciones.capturarCampo(entradaTeclado, "id", "0")));
        int eliminar = model.deleteContacto(deletContacto.getId());     
    }
    
    private static void insertarContacto(){
        Contacto nuevoContacto = new Contacto();
        Funciones.encabezado("Nuevo Contacto");
        nuevoContacto.setNombre(Funciones.capturarCampo(entradaTeclado, "Nombre", "Juan"));
        nuevoContacto.setDescripcion(Funciones.capturarCampo(entradaTeclado, "Decripcion", "Familiar"));
        nuevoContacto.setNumero(Integer.parseInt(Funciones.capturarCampo(entradaTeclado, "Numero", "123")));
        nuevoContacto.setEdad(Integer.parseInt(Funciones.capturarCampo(entradaTeclado, "Edad", "20")));
        Funciones.separador();
        
        int insertado = model.agregarContacto(nuevoContacto);
        if (insertado > 0){
            Funciones.print("Contacto Agregado!!!");
        }
        Funciones.separador();
    }
}
