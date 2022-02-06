/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.dao;

/**
 *
 * @author KVN
 */
public class Contacto {

    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    /**
     * @return the _descripcion
     */
    public String getDescripcion() {
        return _descripcion;
    }

    /**
     * @param _descripcion the _descripcion to set
     */
    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    /**
     * @return the _numero
     */
    public int getNumero() {
        return _numero;
    }

    /**
     * @param _numero the _numero to set
     */
    public void setNumero(int _numero) {
        this._numero = _numero;
    }

    /**
     * @return the _edad
     */
    public int getEdad() {
        return _edad;
    }

    /**
     * @param _edad the _edad to set
     */
    public void setEdad(int _edad) {
        this._edad = _edad;
    }

    /**
     * @return the _id
     */
    public int getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(int _id) {
        this._id = _id;
    }

    
    public String getRow(){
        return String.format("%d\t%s\t%s\t%d\t%d", _id, _nombre, _descripcion, _numero, _edad);
    }
    private int _id;
    private String _nombre;
    private String _descripcion;
    private int _numero;
    private int _edad;
    
}
