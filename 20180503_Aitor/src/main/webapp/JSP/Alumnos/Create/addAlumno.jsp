<%-- 
    Document   : addAlumno
    Created on : 05-may-2018, 18:45:38
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar alumno</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen"/>
    </head>
    <body>
        <div class="columnasCentradas">
            <h1>Insertar Alumno</h1>
            <form action="Controlador" method="POST">
                <table style="margin: 0 auto;">
                    <tr>
                        <td><lable for="nombre">Nombre: </lable></td>
                        <td><input type="text" id="nombre" name="nombre" value="${requestScope.nombreGet}" required/></td>
                    </tr>
                    <tr>
                        <td><label for="grupo">Grupo:</label></td>
                        <td><input type="text" id="grupo" name="grupo" value="${requestScope.grupoGet}"/></td>
                    </tr>
                    <tr>
                        <td><label for="equipo">Equipo: </label></td>
                        <td>
                            <select id="equipo" name="equipo">
                                <c:forEach var="equipos" items="${requestScope.equipos}">
                                    <option value="${equipos.idEquipo}"><c:out value="${equipos.marca}"/></option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table><br>
                <input type="submit" name="enviar" value="Insertar Alumno"/>
                <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="MenuPrincipal" value="Menu Principal"/></a> <br><br>
            </form>
        </div>
    </body>
</html>
