/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;

/**
 *
 * @author Daw2
 */
public class Alumno implements Serializable{
    
    private int idAlumno;
    private String nombre;
    private String grupo;
    private Equipo equipo;

    public Alumno() {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.grupo = grupo;
        this.equipo = equipo;
    }
    
    public Alumno(int idAlumno, String nombre, String grupo, Equipo equipo) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.grupo = grupo;
        this.equipo = equipo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
