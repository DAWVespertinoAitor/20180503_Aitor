/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Equipo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daw2
 */
public class EquiposDAO implements IEquiposDAO {

    @Override
    public void addEquipo(Equipo equipo) {
        String sql = "INSERT INTO equipos (marca, numSerie) VALUES (?,?)";

        PreparedStatement preparada;

        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, equipo.getMarca());
            preparada.setString(2, equipo.getNumSerie());
            preparada.execute();          

        } catch (SQLException ex) {
            ex.getStackTrace();
        }
    }

    @Override
    public ArrayList<Equipo> getEquipos() {
        String sql = "SELECT * FROM equipos";

        ArrayList<Equipo> listaEquipos = new ArrayList();
        Statement sentencia;
        try {
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                Equipo equipo = new Equipo();
                equipo.setIdEquipo(Integer.parseInt(resultado.getString("idEquipo")));
                equipo.setMarca(resultado.getString("marca"));
                equipo.setNumSerie(resultado.getString("numSerie"));
                listaEquipos.add(equipo);

            }
            System.out.println(listaEquipos.get(0).getMarca());
            System.out.println(listaEquipos.get(1).getMarca());
            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        }

        return listaEquipos;
    }

    @Override
    public Equipo getEquipo(int idEquipo) {

        Equipo equipo = new Equipo();
        String sql = "SELECT * FROM equipos where idEquipo = " + idEquipo;
        Statement sentencia;
        try {
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                equipo.setIdEquipo(Integer.parseInt(resultado.getString("idEquipo")));
                equipo.setMarca(resultado.getString("marca"));
                equipo.setNumSerie(resultado.getString("numSerie"));

            }
            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        }

        return equipo;
    }

    @Override
    public ArrayList<Equipo> getEquiposSinAlumnos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateEquipo(Equipo equipo) {
        String sql = "UPDATE equipos SET marca = '"+equipo.getMarca()+"', numSerie = '"+equipo.getNumSerie()+"' WHERE idEquipo = "+equipo.getIdEquipo();
    
        PreparedStatement preparada;
        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.execute();

        } catch (SQLException ex) {
            ex.getStackTrace();
        }
    }

    @Override
    public void deleteEquipo(Equipo equipo) {
        String sql = "DELETE FROM equipos WHERE idEquipo = " + equipo.getIdEquipo();
        PreparedStatement preparada;
        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.execute();

        } catch (SQLException ex) {
            ex.getStackTrace();
        }
    }

}
