/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

/**
 *
 * @author Daw2
 */
public class Equipo {
    
    private int idEquipo; 
    private String marca;
    private String numSerie;
    
    public Equipo() {
        this.idEquipo = idEquipo;
        this.marca = marca;
        this.numSerie = numSerie;
    }
    
    public Equipo(int idEquipo, String marca, String numSerie) {
        this.idEquipo = idEquipo;
        this.marca = marca;
        this.numSerie = numSerie;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
}
