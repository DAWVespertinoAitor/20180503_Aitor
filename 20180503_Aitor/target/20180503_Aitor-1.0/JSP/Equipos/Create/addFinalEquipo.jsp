<%-- 
    Document   : addFinalEquipo
    Created on : 06-may-2018, 22:49:31
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
            <h1 style="color: green;">Datos introducidos correctamente</h1>
            <table style="margin: 0 auto;">
                <tr>
                    <td><lable for="marca">Marca: </lable></td>
                <td><input type="text" id="marca" name="marca" value="${requestScope.equipo.marca}" style="border: 1px solid white;" readonly/></td>
                </tr>
                <tr>
                    <td><label for="grupo">Grupo:</label></td>
                    <td><input type="text" id="grupo" name="grupo" value="${requestScope.equipo.numSerie}"  style="border: 1px solid white;" readonly/></td>
                </tr>
            </table><br>
            <a href="<%=request.getContextPath()%>/index.html">
                <input type="button" name="menuPrincipal" value="Menu Principal"/>
            </a><br><br>
        </div>
    </body>
</html>
