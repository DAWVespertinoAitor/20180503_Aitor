/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Equipo;
import es.albarregas.dao.IAlumnosDAO;
import es.albarregas.dao.IEquiposDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author aitor
 */
@WebServlet(name = "Conclusion", urlPatterns = {"/Conclusion"})
public class Conclusion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "";
        String eleccion = request.getParameter("enviar");
        DAOFactory daof = DAOFactory.getDAOFactory();
        IEquiposDAO edao = daof.getEquiposDAO();
        IAlumnosDAO adao = daof.getAlumnosDAO();
        List<Alumno> alumnos = new ArrayList();

        if (eleccion != null) {
            Alumno alumno = new Alumno();
            Equipo equipo = new Equipo();
            switch (eleccion) {
                case "Insertar Alumno":

                    alumno = new Alumno();
                    equipo = new Equipo();

                    alumno.setNombre(request.getParameter("nombre"));
                    alumno.setGrupo(request.getParameter("grupo"));
                    equipo = edao.getEquipo(Integer.parseInt(request.getParameter("equipo")));
                    alumno.setEquipo(equipo);
                    adao.addAlumno(alumno);
                    request.setAttribute("alumno", alumno);
                    url = "JSP/Alumnos/Create/addFinalAlumno.jsp";
                    break;
                case "Insertar Equipo":
                    equipo = new Equipo();

                    equipo.setMarca(request.getParameter("marca"));
                    equipo.setNumSerie(request.getParameter("numSerie"));
                    edao.addEquipo(equipo);
                    request.setAttribute("equipo", equipo);
                    url = "JSP/Equipos/Create/addFinalEquipo.jsp";
                    break;
                case "read":
                    url = "JSP/read/read.jsp";
                    break;
                case "Actualizar Alumno":
                    alumno = new Alumno();
                    equipo = new Equipo();
                    alumno.setIdAlumno(Integer.parseInt(request.getParameter("idAlumno")));
                    alumno.setNombre(request.getParameter("nombre"));
                    alumno.setGrupo(request.getParameter("grupo"));
                    equipo = edao.getEquipo(Integer.parseInt(request.getParameter("equipo")));
                    alumno.setEquipo(equipo);

                    adao.updateAlumno(alumno);
                    request.setAttribute("alumnoActual", alumno);
                    url = "JSP/Alumnos/Update/updateFinAlumno.jsp";
                    break;
                case "Actualizar Equipo":
                    equipo = new Equipo();
                    equipo.setIdEquipo(Integer.parseInt(request.getParameter("idEquipo")));
                    equipo.setMarca(request.getParameter("marca"));
                    equipo.setNumSerie(request.getParameter("numSerie"));
                    edao.updateEquipo(equipo);
                    request.setAttribute("equipoActual", equipo);
                    url = "JSP/Equipos/Update/updateFinEquipo.jsp";
                    break;
                case "Eliminar Alumnos":
                    String[] idAlumnos = request.getParameterValues("idAlumno");
                    alumno = new Alumno();
                    for (int i = 0; i < idAlumnos.length; i++) {
                        alumno = adao.getAlumno(Integer.parseInt(idAlumnos[i]));
                        adao.deleteAlumno(alumno);
                    }
                    url = "JSP/Alumnos/Delete/deleteFinAlumno.jsp";
                    break;
                case "Eliminar Equipo":
                    String[] idEquipos = request.getParameterValues("idEquipo");
                    equipo = new Equipo();
                    for (int i = 0; i < idEquipos.length; i++) {
                        equipo = edao.getEquipo(Integer.parseInt(idEquipos[i]));
                        edao.deleteEquipo(equipo);
                    }
                    url = "JSP/Equipos/Delete/deleteFinEquipo.jsp";
                    break;
            }
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
