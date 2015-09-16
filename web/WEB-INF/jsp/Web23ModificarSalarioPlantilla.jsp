<%-- 
    Document   : Web23ModificarSalarioPlantilla
    Created on : 15-sep-2015, 14:02:14
    Author     : NachoP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"
          prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificar Salario Plantilla DAO</h1>
              <form action="Web23ModificarSalarioPlantilla.htm">
            Introduzca un incremento: 
            <input type="text" name="salario"/>
            <button type="submit">
                Incrementar Salarios
            </button>
        </form>
        <hr/>
        <table border="1">
            <tr>
                <th>Apellido</th>
                <th>Funcion</th>
                <th>Salario</th>
                <th>Seleccion</th>
            </tr>
            <c:forEach items="${plantilla}" var="fila">
                <tr>
                    <td>
                        <c:out value="${fila.apellido}"/>
                    </td>
                    <td>
                        <c:out value="${fila.funcion}"/>
                    </td>
                    <td>
                        <c:out value="${fila.salario}"/>
                    </td>
                    <td style="text-align: center; vertical-align: middle">
                        <input type="checkbox"  name="empno" value="${fila.apellido}"/>
                    </td>
                </tr>
            </c:forEach> 
        </table>        
    </body>
</html>
