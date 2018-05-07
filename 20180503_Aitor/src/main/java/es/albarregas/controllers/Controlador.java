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
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

                    request.setAttribute("alumno", alumno);

                    url = "JSP/Alumnos/Create/addConfirmaAlumno.jsp";
                    break;
                case "Insertar Equipo":

                    equipo = new Equipo();

                    equipo.setMarca(request.getParameter("marca"));
                    equipo.setNumSerie(request.getParameter("numSerie"));

                    request.setAttribute("equipo", equipo);

                    url = "JSP/Equipos/Create/addConfirmaEquipo.jsp";
                    break;
                case "Actualizar Alumno":

                    String alumnoId = request.getParameter("idAlumno");
                    alumno = new Alumno();
                    ArrayList<Equipo> listaEquipos = new ArrayList();
                    alumno = adao.getAlumno(Integer.parseInt(alumnoId));

                    listaEquipos = edao.getEquipos();

                    request.setAttribute("listaEquipos", listaEquipos);
                    request.setAttribute("alumno", alumno);
                    url = "JSP/Alumnos/Update/updateListAlumno.jsp";
                    break;
                case "Actualizar Equipo":

                    String equipoId = request.getParameter("idEquipo");
                    equipo = new Equipo();
                    listaEquipos = new ArrayList();
                    equipo = edao.getEquipo(Integer.parseInt(equipoId));
                    request.setAttribute("equipo", equipo);
                    url = "JSP/Equipos/Update/updateListEquipo.jsp";
                    break;
                case "Eliminar Alumnos":

                    String[] idAlumno = request.getParameterValues("idAlumno");
                    ArrayList<Alumno> listaAlumnos = new ArrayList();
                    alumno = new Alumno();
                    for (int i = 0; i < idAlumno.length; i++) {
                        alumno = adao.getAlumno(Integer.parseInt(idAlumno[i]));
                        System.out.println(alumno.getNombre());
                        listaAlumnos.add(alumno);
                    }

                    request.setAttribute("alumnosEscogidos", listaAlumnos);
                    url = "JSP/Alumnos/Delete/deleteListAlumno.jsp";
                    break;
                case "Eliminar Equipos":

                    String[] idEquipo = request.getParameterValues("idEquipo");
                    listaEquipos = new ArrayList();
                    equipo = new Equipo();
                    for (int i = 0; i < idEquipo.length; i++) {
                        equipo = edao.getEquipo(Integer.parseInt(idEquipo[i]));
                        listaEquipos.add(equipo);
                    }

                    request.setAttribute("equiposEscogidos", listaEquipos);
                    url = "JSP/Equipos/Delete/deleteListEquipo.jsp";
                    break;
            }
        }

        request.getRequestDispatcher(url).forward(request, response);
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
