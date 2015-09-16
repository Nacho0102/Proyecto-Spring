<%-- 
    Document   : Web24ClientesDaoSupport
    Created on : 16-sep-2015, 11:41:21
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
        <h1>Insertar clientes con clase JdbcDaosupport</h1>
        
        <form action="Web24ClientesDaoSupport.htm">
            
            IdCliente:
            <input type="text" name="idcliente"/>
            Nombre:
            <input type="text" name="nombre"/>
            Direccion:
            <input type="text" name="direccion"/>
            <br/>
            <button type="submit">Insertar</button>
            
             <table border="1">
            <tr>
                <th>IdCliente</th>
                <th>Nombre</th>
                <th>Direccion</th>
                <th>Foto</th>
            </tr>
            <c:forEach items="${clientes}" var="fila">
                <tr>
                    <td>
                        <c:out value="${fila.idcliente}"/>
                    </td>
                    <td>
                        <c:out value="${fila.nombre}"/>
                    </td>
                    <td>
                        <c:out value="${fila.direccion}"/>
                    </td>
                    <td>
                        <c:out value="${fila.foto}"/>
                    </td>
                </tr>
            </c:forEach> 
        </table>    
        </form>
    </body>
</html>
