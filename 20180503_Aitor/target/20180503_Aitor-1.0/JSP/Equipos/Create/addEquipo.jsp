<%-- 
    Document   : addEquipo
    Created on : 06-may-2018, 22:48:50
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Equipo</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen"/>
    </head>
    <body>
        <div class="columnasCentradas">
            <h1>Insertar Equipo</h1>
            <form action="Controlador" method="POST">
                <table style="margin: 0 auto;">
                    <tr>
                        <td><lable for="marca">Marca: </lable></td>
                        <td><input type="text" id="marca" name="marca" value="${requestScope.marcaGet}" required/></td>
                    </tr>
                    <tr>
                        <td><label for="numSerie">Numero de Serie: </label></td>
                        <td><input type="text" id="numSerie" name="numSerie" value="${requestScope.numSerieGet}"/></td>
                    </tr>
                </table><br>
                <input type="submit" name="enviar" value="Insertar Equipo"/>
                <a href="<%=request.getContextPath()%>/index.html"><input type="button" name="MenuPrincipal" value="Menu Principal"/></a> <br><br>
            </form>
        </div>
    </body>
</html>
