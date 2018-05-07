<%-- 
    Document   : addConfirmaAlumno
    Created on : 05-may-2018, 18:45:51
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confimar Alumno</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen"/>
    </head>
    <body>
        <div class="columnasCentradas">
            <h1>Confirmar datos del Alumno</h1>
            <form action="Conclusion" method="POST">
                <table style="margin: 0 auto;">
                    <tr>
                        <td><lable for="nombre">Nombre: </lable></td>
                        <td><input type="text" id="nombre" name="nombre" value="${requestScope.alumno.nombre}" readonly style="border:1px solid white;"/></td>
                    </tr>
                    <tr>
                        <td><label for="grupo">Grupo:</label></td>
                        <td><input type="text" id="grupo" name="grupo" value="${requestScope.alumno.grupo}" readonly style="border:1px solid white;"/></td>
                    </tr>
                    <tr>
                        <td><label for="equipo">Equipo: </label></td>
                        <td><input type="text" id="equipo" name="equipoMarca" value="${requestScope.alumno.equipo.marca}" readonly style="border:1px solid white;"/></td>
                        <input type="hidden" name="equipo" value="${requestScope.alumno.equipo.idEquipo}"/>
                    </tr>
                </table><br>
                <input type="submit" name="enviar" value="Insertar Alumno"/>
                <a href="<%=request.getContextPath()%>/Eleccion?opcion=addAlumno&nombreGet=${requestScope.alumno.nombre}&grupoGet=${requestScope.alumno.grupo}">
                    <input type="button" name="volver" value="Volver"/>
                </a><br><br>
            </form>
        </div>
    </body>
</html>
