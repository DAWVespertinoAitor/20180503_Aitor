<%-- 
    Document   : deleteListEquipo
    Created on : 06-may-2018, 23:14:23
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Eliminar Equipos</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen"/>
    </head>
    <body>
        <div class="columnasCentradas">
            <h2>¿Esta seguro de que desea borrar a este/os equipo/s?</h2>
            <form action="Conclusion" method="POST">
                <table style="margin: 0 auto;">
                    <tr>
                        <th></th>
                        <th>Marca |</th>
                        <th>Grupo</th>
                    </tr>
                    <c:forEach var="equipos" items="${requestScope.equiposEscogidos}">
                        <tr>
                            <td><input type="hidden" name="idEquipo" value="${equipos.idEquipo}"/></td>
                            <td><c:out value="${equipos.marca}"/></td>
                            <td><c:out value="${equipos.numSerie}"/></td>
                        </tr>
                    </c:forEach>
                </table><br>
                <input type="submit" name="enviar" value="Eliminar Equipo"/>
                <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="menuPrincipal" value="Menu Principal"/></a> <br><br>
            </form>
        </div>
    </body>
</html>
