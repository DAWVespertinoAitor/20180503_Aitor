<%-- 
    Document   : visualizarEquipos
    Created on : 06-may-2018, 21:49:22
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizar Equipos</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen"/>
    </head>
    <body>
        <div class="columnasCentradas">
            <h1>Lista de Equipos</h1>
            <table style="margin: 0 auto;">
                <tr>
                    <th>ID Equipo |</th>
                    <th>Marca |</th>
                    <th>Numero de Serie</th>
                </tr>
                <c:forEach var="equipos" items="${requestScope.listaEquipos}">
                    <tr>
                        <c:if test="${equipos.idEquipo != 4}">
                            <td><c:out value="${equipos.idEquipo}"/></td>
                            <td><c:out value="${equipos.marca}"/></td>
                            <td><c:out value="${equipos.numSerie}"/></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table><br>
            <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="menuPrincipal" value="Menu Principal"/></a> <br><br>
        </div>
    </body>
</html>
