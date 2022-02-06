/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author KVN
 */

public class ContactosModel {
    private Connection _conexion = null;
    public ContactosModel(){
        _conexion = Conexion.getConexion();
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS contactos"
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + " nombre TEXT,"
                + " descripcion TEXT,"
                + " numero NUMERIC,"
                + " edad NUMERIC);";
        try{
            Statement comando = _conexion.createStatement();
            int resultado = comando.executeUpdate(sqlCreateTable);
        }catch (Exception ex){
            System.err.println(ex.getMessage());  
        }
    }
    
    public ArrayList<Contacto> obtenerContactos(){
        try{
            ArrayList contactos = new ArrayList<Contacto>();
            Statement comandoSQL = _conexion.createStatement();
            ResultSet registroEnTabla = comandoSQL.executeQuery("SELECT * FROM contactos;");
            while (registroEnTabla.next()){
                Contacto contactoActual = new Contacto ();
                contactoActual.setId(registroEnTabla.getInt("id"));
                contactoActual.setNombre(registroEnTabla.getString("nombre"));
                contactoActual.setDescripcion(registroEnTabla.getString("descripcion"));
                contactoActual.setNumero(registroEnTabla.getInt("numero"));
                contactoActual.setEdad(registroEnTabla.getInt("edad"));
                contactos.add(contactoActual);
            }
            return contactos;
        }catch (Exception ex){
            System.err.println(ex.getMessage());
            return new ArrayList<Contacto>();
        }
    }
    
    public Contacto obtenerContacto(int id){
        try{
            PreparedStatement comandoSQL = _conexion.prepareStatement("SELECT * FROM contactos where id = ?;");
            comandoSQL.setInt(1, id);
            ResultSet registroEnTabla = comandoSQL.executeQuery();
            Contacto contactoActual = new Contacto();
            while (registroEnTabla.next()){
                contactoActual.setId(registroEnTabla.getInt("id"));
                contactoActual.setNombre(registroEnTabla.getString("nombre"));
                contactoActual.setDescripcion(registroEnTabla.getString("descripcion"));
                contactoActual.setNumero(registroEnTabla.getInt("numero"));
                contactoActual.setEdad(registroEnTabla.getInt("edad"));
                break;
            }
            return contactoActual;
        }catch (Exception ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public int agregarContacto (Contacto nuevoContacto){
        try{
            String inserSql = "INSERT INTO contactos (nombre, descripcion, numero, edad) values (?, ?, ?, ?)";
            PreparedStatement comandoSQL = _conexion.prepareStatement(inserSql);
            comandoSQL.setString(1, nuevoContacto.getNombre());
            comandoSQL.setString(2, nuevoContacto.getDescripcion());
            comandoSQL.setInt(4, nuevoContacto.getNumero());
            comandoSQL.setInt(5, nuevoContacto.getEdad());
            
            int RegistroAfectados = comandoSQL.executeUpdate();
            comandoSQL.close();
            return RegistroAfectados;
        }catch (Exception ex){
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    
    public int actualizarContacto (Contacto updateContacto){
        try{
            String inserSql = "UPDATE contactos SET nombre=?, descripcion=?, numero=?, edad=? where id=?;";
            PreparedStatement comandoSQL = _conexion.prepareStatement(inserSql);
            comandoSQL.setString(1, updateContacto.getNombre());
            comandoSQL.setString(2, updateContacto.getDescripcion());
            comandoSQL.setInt(3, updateContacto.getNumero());
            comandoSQL.setInt(4, updateContacto.getEdad());
            
            int RegistroAfectados = comandoSQL.executeUpdate();
            comandoSQL.close();
            return RegistroAfectados;
        }catch (Exception ex){
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    
    public int deleteContacto (int id){
        try{
            String deleteSql = "DELETE FROM contactos where id =?;";
            PreparedStatement comandoSQL = _conexion.prepareStatement(deleteSql);
            comandoSQL.setInt(1, id);
            
            int RegistroAfectados = comandoSQL.executeUpdate();
            comandoSQL.close();
            return RegistroAfectados;
        }catch (Exception ex){
            System.err.println(ex.getMessage());
            return 0;
        }
    }
}
