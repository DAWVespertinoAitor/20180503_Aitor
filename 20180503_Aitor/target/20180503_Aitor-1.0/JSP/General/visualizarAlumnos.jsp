<%-- 
    Document   : visualizarAlumnos
    Created on : 06-may-2018, 21:49:14
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizar Alumnos</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen"/>
    </head>
    <body>
        <div class="columnasCentradas">
            <h1>Lista de alumnos</h1>
            <table style="margin: 0 auto;">
                <tr>
                    <th>ID Alumno |</th>
                    <th>Nombre |</th>
                    <th>Grupo |</th>
                    <th>Equipo</th>
                </tr>
                <c:forEach var="alumnos" items="${requestScope.listaAlumnos}">
                    <tr>
                        <td><c:out value="${alumnos.idAlumno}"/></td>
                        <td><c:out value="${alumnos.nombre}"/></td>
                        <td><c:out value="${alumnos.grupo}"/></td>
                        <td><c:out value="${alumnos.equipo.marca}"/></td>
                    </tr>
                </c:forEach>
            </table><br>
            <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="menuPrincipal" value="Menu Principal"/></a> <br><br>
        </div>
    </body>
</html>
