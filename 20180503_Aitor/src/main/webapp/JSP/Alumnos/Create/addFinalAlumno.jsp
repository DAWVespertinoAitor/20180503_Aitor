<%-- 
    Document   : addFinalAlumno
    Created on : 05-may-2018, 18:46:01
    Author     : aitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finalizar Insercion</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilos.css" media="screen"/>
    </head>
    <body>
        <div class="columnasCentradas">
            <h1 style="color: green;">Datos introducidos correctamente</h1>
            <form action="Conclusion" method="POST">
                <table style="margin: 0 auto;">
                    <tr>
                        <td><lable for="nombre">Nombre: </lable></td>
                        <td><input type="text" id="nombre" name="nombre" value="${requestScope.alumno.nombre}" style="border: 1px solid white;" readonly/></td>
                    </tr>
                    <tr>
                        <td><label for="grupo">Grupo:</label></td>
                        <td><input type="text" id="grupo" name="grupo" value="${requestScope.alumno.grupo}"  style="border: 1px solid white;" readonly/></td>
                    </tr>
                    <tr>
                        <td><label for="equipo">Equipo: </label></td>
                        <td><input type="text" id="equipo" name="equipoMarca" value="${requestScope.alumno.equipo.marca}"  style="border: 1px solid white;" readonly/></td>
                        <input type="hidden" name="equipo" value="${requestScope.alumno.equipo.idEquipo}"/>
                    </tr>
                </table><br>
                <a href="<%=request.getContextPath()%>/index.html">
                    <input type="button" name="menuPrincipal" value="Menu Principal"/>
                </a><br><br>
            </form>
        </div>
    </body>
</html>
