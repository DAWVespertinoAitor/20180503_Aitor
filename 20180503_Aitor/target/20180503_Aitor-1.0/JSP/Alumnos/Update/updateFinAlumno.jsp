<%-- 
    Document   : updateFinAlumno
    Created on : 05-may-2018, 18:48:15
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumno Actualizado</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen"/>
    </head>
    <body>
        <div class="columnasCentradas">
            <h1 style="color: green;">¡Datos actualizados correctamente!</h1>
            <table style="margin: 0 auto;">
                    <tr>
                        <td>ID Alumno: </td>
                        <td><c:out value="${requestScope.alumnoActual.idAlumno}"/></td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td><c:out value="${requestScope.alumnoActual.nombre}"/></td>
                    </tr>
                    <tr>
                        <td>Grupo: </td>
                        <td><c:out value="${requestScope.alumnoActual.grupo}"/></td>
                    </tr>
                    <tr>
                        <td>Equipo: </td>
                        <td><c:out value="${requestScope.alumnoActual.equipo.marca}"/></td>
                    </tr>
                </table><br>
            <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="menuPrincipal" value="Menu Principal"/></a><br><br>
        </div>
    </body>
</html>
