<%-- 
    Document   : updateFinAlumno
    Created on : 07-may-2018, 3:12:36
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Equipo Actualizado</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen"/>
    </head>
    <body>
        <div class="columnasCentradas">
            <h1 style="color: green;">¡Datos actualizados correctamente!</h1>
            <table style="margin: 0 auto;">
                    <tr>
                        <td>ID Equipo: </td>
                        <td><c:out value="${requestScope.equipoActual.idEquipo}"/></td>
                    </tr>
                    <tr>
                        <td>Marca: </td>
                        <td><c:out value="${requestScope.equipoActual.marca}"/></td>
                    </tr>
                    <tr>
                        <td>Numero de Serie: </td>
                        <td><c:out value="${requestScope.equipoActual.numSerie}"/></td>
                    </tr>
                </table><br>
            <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="menuPrincipal" value="Menu Principal"/></a><br><br>
        </div>
    </body>
</html>
