<%-- 
    Document   : deleteEquipo
    Created on : 06-may-2018, 23:07:58
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen"/>
    </head>
    <body>
        <div class="columnasCentradas">
            <h1>Eliminar Equipos</h1>
            <form action="Controlador" method="POST">
                <table style="margin: 0 auto;">
                    <tr>
                        <th></th>
                        <th>Marca |</th>
                        <th>Numero de  </th>
                    </tr>
                    <c:forEach var="equipos" items="${requestScope.equipos}">
                        <c:if test="${equipos.idEquipo != 4}">
                            <tr>
                                <td><input type="checkbox" name="idEquipo" value="${equipos.idEquipo}"/></td>
                                <td><c:out value="${equipos.marca}"/></td>
                                <td><c:out value="${equipos.numSerie}"/></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table><br>
                <input type="submit" name="enviar" value="Eliminar Equipos"/>
                <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="menuPrincipal" value="Menu Principal"/></a> <br><br>
            </form>
        </div>
    </body>
</html>
