<%-- 
    Document   : updateListEquipo
    Created on : 07-may-2018, 3:12:28
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Alumno</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen"/>
    </head>
    <body>
        <div class="columnasCentradas">
            <h1>Actualizar Equipo</h1>
            <form action="Conclusion" method="POST">
                <table style="margin: 0 auto;">
                    <tr>
                        <td><label for="idEquipo">ID Equipo:</label></td>
                        <td><input type="text" id="idEquipo" name="idEquipo" value="${requestScope.equipo.idEquipo}" readonly/></td>
                    </tr>
                    <tr>
                        <td><label for="marca">Marca: </label></td>
                        <td><input type="text" id="marca" name="marca" value="${requestScope.equipo.marca}"/></td>
                    </tr>
                    <tr>
                        <td><label for="numSerie">Numero de Serie: </label></td>
                        <td><input type="text" id="numSerie" name="numSerie" value="${requestScope.equipo.numSerie}"/></td>
                    </tr>
                </table><br>
                <input type="submit" name="enviar" value="Actualizar Equipo"/>
                <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="menuPrincipal" value="Menu Principal"/></a> <br><br>
            </form>
        </div>
    </body>
</html>
