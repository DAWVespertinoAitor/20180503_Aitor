<%-- 
    Document   : addConfirmaEquipo
    Created on : 06-may-2018, 22:49:19
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
            <h1>Confirmar datos del Equipo</h1>
            <form action="Conclusion" method="POST">
                <table style="margin: 0 auto;">
                    <tr>
                        <th><lable for="marca">Marca: </lable></th>
                        <td><input type="text" id="marca" name="marca" value="${requestScope.equipo.marca}" readonly style="border:1px solid white;"/></td>
                    </tr>
                    <tr>
                        <th><label for="numSerie">Numero de Serie: </label></th>
                        <td><input type="text" id="numSerie" name="numSerie" value="${requestScope.equipo.numSerie}" readonly style="border:1px solid white;"/></td>
                    </tr>
                </table><br>
                <input type="submit" name="enviar" value="Insertar Equipo"/>
                <a href="<%=request.getContextPath()%>/Eleccion?opcion=addEquipo&marcaGet=${requestScope.equipo.marca}&numSerieGet=${requestScope.equipo.numSerie}">
                    <input type="button" name="volver" value="Volver"/>
                </a><br><br>
            </form>
        </div>
    </body>
</html>
