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

/**
 *
 * @author aitor
 */
@WebServlet(name = "Eleccion", urlPatterns = {"/Eleccion"})
public class Eleccion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "";
        String opcion = request.getParameter("opcion");
        DAOFactory daof = DAOFactory.getDAOFactory();
        IEquiposDAO edao = daof.getEquiposDAO();
        IAlumnosDAO adao = daof.getAlumnosDAO();

        if (opcion != null) {
            ArrayList<Equipo> listaEquipos = new ArrayList();
            ArrayList<Alumno> listaAlumnos = new ArrayList();
            switch (opcion) {
                //AÑADIR ALUMNO
                case "addAlumno":
                    listaEquipos = new ArrayList();
                    listaEquipos = edao.getEquipos();
                    request.setAttribute("equipos", listaEquipos);
                    if (request.getParameter("nombreGet") != null && request.getParameter("grupoGet") != null) {
                        request.setAttribute("nombreGet", request.getParameter("nombreGet"));
                        request.setAttribute("grupoGet", request.getParameter("grupoGet"));
                    }
                    url = "JSP/Alumnos/Create/addAlumno.jsp";
                    break;
                //AÑADIR EQUIPO
                case "addEquipo":
                    if (request.getParameter("marcaGet") != null && request.getParameter("numSerieGet") != null) {
                        request.setAttribute("marcaGet", request.getParameter("marcaGet"));
                        request.setAttribute("numSerieGet", request.getParameter("numSerieGet"));
                    }
                    url = "JSP/Equipos/Create/addEquipo.jsp";
                    break;
                //LISTA ALUMNOS
                case "viewAlumno":
                    listaAlumnos = new ArrayList();
                    listaAlumnos = adao.getAlumnos();
                    request.setAttribute("listaAlumnos", listaAlumnos);
                    url = "JSP/General/visualizarAlumnos.jsp";
                    break;
                //LISTA EQUIPOS
                case "viewEquipo":
                    listaEquipos = new ArrayList();
                    listaEquipos = edao.getEquipos();
                    request.setAttribute("listaEquipos", listaEquipos);
                    url = "JSP/General/visualizarEquipos.jsp";
                    break;
                //ACTUALIZAR ALUMNO
                case "updateAlumno":
                    listaAlumnos = new ArrayList();
                    listaAlumnos = adao.getAlumnos();
                    request.setAttribute("alumnos", listaAlumnos);
                    url = "JSP/Alumnos/Update/updateAlumno.jsp";
                    break;
                //ACTUALIZAR EQUIPO
                case "updateEquipo":
                    listaEquipos = new ArrayList();
                    listaEquipos = edao.getEquipos();
                    request.setAttribute("equipos", listaEquipos);
                    url = "JSP/Equipos/Update/updateEquipo.jsp";
                    break;
                //ELIMINAR ALUMNO/s
                case "deleteAlumno":
                    listaAlumnos = new ArrayList();
                    listaAlumnos = adao.getAlumnos();
                    request.setAttribute("alumnos", listaAlumnos);
                    url = "JSP/Alumnos/Delete/deleteAlumno.jsp";
                    break;
                //ELIMINAR EQUIPO/s
                case "deleteEquipo":
                    listaEquipos = new ArrayList();
                    listaEquipos = edao.getEquipos();
                    request.setAttribute("equipos", listaEquipos);
                    url = "JSP/Equipos/Delete/deleteEquipo.jsp";
                    break;
                case "viewAll":
                    listaAlumnos = new ArrayList();
                    listaAlumnos = adao.getAlumnos();
                    request.setAttribute("listaAlumnos", listaAlumnos);
                    url = "JSP/General/visualizarTodo.jsp";
                    break;
            }
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
