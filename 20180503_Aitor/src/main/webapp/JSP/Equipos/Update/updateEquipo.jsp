<%-- 
    Document   : updateEquipo
    Created on : 07-may-2018, 3:12:17
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Equipo</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen"/>
    </head>
    <body>
        <div class="columnasCentradas">
            <h1>Actualizar Equipo</h1>
            <form action="Controlador" method="POST">
                <table style="margin: 0 auto;">
                    <tr>
                        <th></th>
                        <th>Marca |</th>
                        <th>Numero de Serie</th>
                    </tr>
                    <c:forEach var="equipos" items="${requestScope.equipos}">
                        <tr>
                            <td><input type="radio" name="idEquipo" value="${equipos.idEquipo}"/></td>
                            <td><c:out value="${equipos.marca}"/></td>
                            <td><c:out value="${equipos.numSerie}"/></td>
                        </tr>
                    </c:forEach>
                </table><br>
                <input type="submit" name="enviar" value="Actualizar Equipo"/>
                <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="menuPrincipal" value="Menu Principal"/></a> <br><br>
            </form>
        </div>
    </body>
</html>
