<%-- 
    Document   : Web18ConsultasParametrizadas
    Created on : 14-sep-2015, 13:55:54
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
        <h1>Consultas parametrizadas Spring JDBC DAO</h1>
        <form action="Web18ConsultasParametrizadas.htm">
            Introduzca una localidad: 
            <input type="text" name="localidad"/>
            <button type="submit">
                Mostrar departamentos
            </button>
        </form>
        <hr/>
        <table border="1">
            <tr>
                <th>Número</th>
                <th>Nombre</th>
                <th>Localidad</th>
            </tr>
            <c:forEach items="${departamentos}" var="fila">
                <tr>
                    <td>
                        <c:out value="${fila.numero}"/>
                    </td>
                    <td>
                        <c:out value="${fila.nombre}"/>
                    </td>
                    <td>
                        <c:out value="${fila.localidad}"/>
                    </td>
                </tr>
            </c:forEach> 
        </table>        
    </body>
</html>
