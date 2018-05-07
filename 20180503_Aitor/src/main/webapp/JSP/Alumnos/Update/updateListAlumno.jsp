<%-- 
    Document   : updateListAlumno
    Created on : 05-may-2018, 18:47:53
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar alumno</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen"/>
    </head>
    <body>
        <div class="columnasCentradas">
            <h1>Actualizar Alumno</h1>
            <form action="Conclusion" method="POST">
                <table style="margin: 0 auto;">
                    <tr>
                        <td><label for="idAlumno">ID Alumno:</label></td>
                        <td><input type="text" id="idAlumno" name="idAlumno" value="${requestScope.alumno.idAlumno}" readonly/></td>
                    </tr>
                    <tr>
                        <td><label for="nombre">Nombre: </label></td>
                        <td><input type="text" id="nombre" name="nombre" value="${requestScope.alumno.nombre}"/></td>
                    </tr>
                    <tr>
                        <td><label for="grupo">Grupo: </label></td>
                        <td><input type="text" name="grupo" value="${requestScope.alumno.grupo}"/></td>
                    </tr>
                    <tr>
                        <td><label for="equipo">Equipo: </label></td>
                        <td>
                            <select name="equipo" id="equipo">
                                <c:forEach var="equipos" items="${requestScope.listaEquipos}">
                                    <c:if test="${equipos.marca == requestScope.alumno.equipo.marca}">
                                        <option value="${equipos.idEquipo}" selected><c:out value="${equipos.marca}"/></option>
                                    </c:if>
                                    <c:if test="${equipos.marca != requestScope.alumno.equipo.marca}">
                                        <option value="${equipos.idEquipo}"><c:out value="${equipos.marca}"/></option>
                                    </c:if>
                                </c:forEach>
                            </select>
                            <input type="hidden" name="equipo" value="${alumno.equipo.idEquipo}"/>
                        </td>
                    </tr>
                </table><br>
                <input type="submit" name="enviar" value="Actualizar Alumno"/>
                <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="menuPrincipal" value="Menu Principal"/></a> <br><br>
            </form>
        </div>
    </body>
</html>
