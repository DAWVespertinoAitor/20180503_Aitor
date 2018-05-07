<%-- 
    Document   : deleteListAlumno
    Created on : 05-may-2018, 18:46:49
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Eliminar Alumno</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen"/>
    </head>
    <body>
        <div class="columnasCentradas">
            <h2>¿Esta seguro de que desea borrar a este/os alumno/s?</h2>
            <form action="Conclusion" method="POST">
                <table style="margin: 0 auto;">
                    <tr>
                        <th></th>
                        <th>Nombre |</th>
                        <th>Grupo |</th>
                        <th>Equipo</th>
                    </tr>
                    <c:forEach var="alumnos" items="${requestScope.alumnosEscogidos}">
                        <tr>
                            <td><input type="hidden" name="idAlumno" value="${alumnos.idAlumno}"/></td>
                            <td><c:out value="${alumnos.nombre}"/></td>
                            <td><c:out value="${alumnos.grupo}"/></td>
                            <td><c:out value="${alumnos.equipo.marca}"/></td>
                        </tr>
                    </c:forEach>
                </table><br>
                <input type="submit" name="enviar" value="Eliminar Alumnos"/>
                <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="menuPrincipal" value="Menu Principal"/></a> <br><br>
            </form>
        </div>
    </body>
</html>
