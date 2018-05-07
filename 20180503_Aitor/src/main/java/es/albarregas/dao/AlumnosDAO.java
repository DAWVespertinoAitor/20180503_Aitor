/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Equipo;
import es.albarregas.daofactory.DAOFactory;
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
public class AlumnosDAO implements IAlumnosDAO {

    @Override
    public void addAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumnos (nombre,grupo,idEquipo) VALUES (?,?,?)";

        PreparedStatement preparada;

        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, alumno.getNombre());
            preparada.setString(2, alumno.getGrupo());
            preparada.setString(3, String.valueOf(alumno.getEquipo().getIdEquipo()));
            preparada.execute();

        } catch (SQLException ex) {
            ex.getStackTrace();
        }

    }

    @Override
    public ArrayList<Alumno> getAlumnos() {
        String sql = "SELECT * FROM alumnos INNER JOIN equipos ON alumnos.idEquipo = equipos.idEquipo";
        ArrayList<Alumno> listaAlumnos = new ArrayList();
        Statement sentencia;
        
        try {
            sentencia = ConnectionFactory.getConnection().createStatement();
            
            ResultSet resultado = sentencia.executeQuery(sql);
            
            while (resultado.next()) {
                
                System.out.println("Entro aqui");
                Alumno alumno = new Alumno();
                Equipo equipo = new Equipo();
                
                alumno.setIdAlumno(Integer.parseInt(resultado.getString("idAlumno")));
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setGrupo(resultado.getString("grupo"));
                
                equipo.setIdEquipo(Integer.parseInt(resultado.getString("idEquipo")));
                equipo.setMarca(resultado.getString("marca"));
                equipo.setNumSerie(resultado.getString("numSerie"));
                
                alumno.setEquipo(equipo);
                listaAlumnos.add(alumno);
                
                System.out.println("AQUIIIIIIIII "+listaAlumnos.get(0).getNombre());
            }
            
            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        }

        return listaAlumnos;
    }

    @Override
    public Alumno getAlumno(int idAlumno) {
        DAOFactory daof = DAOFactory.getDAOFactory();
        IEquiposDAO edao = daof.getEquiposDAO();
        Alumno alumno = new Alumno();
        
        String sql = "SELECT * FROM alumnos where idAlumno = " + idAlumno;
        Statement sentencia;
        try {
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            
            if (resultado.next()) {
                
                
                Equipo equipo = new Equipo();
                
                alumno.setIdAlumno(Integer.parseInt(resultado.getString("idAlumno")));
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setGrupo(resultado.getString("grupo"));
                equipo = edao.getEquipo(Integer.parseInt(resultado.getString("idEquipo")));
                
                alumno.setEquipo(equipo);
            }
            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return alumno;
    }

    @Override
    public ArrayList<Alumno> getAlumnosSinEquipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAlumno(Alumno alumno) {
        
        String sql = "UPDATE alumnos SET nombre = '"+alumno.getNombre()+"', grupo = '"+alumno.getGrupo()+"', idEquipo = "+alumno.getEquipo().getIdEquipo()+" WHERE idAlumno = "+alumno.getIdAlumno();
    
        PreparedStatement preparada;
        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.execute();

        } catch (SQLException ex) {
            ex.getStackTrace();
        }
    }

    @Override
    public void deleteAlumno(Alumno alumno) {
        String sql = "DELETE FROM alumnos WHERE idAlumno = " + alumno.getIdAlumno();
        PreparedStatement preparada;
        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.execute();

        } catch (SQLException ex) {
            ex.getStackTrace();
        }
    }

}
