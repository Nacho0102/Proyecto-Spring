<%-- 
    Document   : Web21EliminarDepartamentosBatch
    Created on : 15-sep-2015, 10:49:48
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
        <h1>Eliminar Departamento Batch DAO</h1>
        
        <h3 style="color:blue">
            <c:out value="${mensaje}"/>
        </h3>
        
        <form action="Web21EliminarDepartamentosBatch.htm">
            
               <table border="1">
            <tr>
                <th>Número</th>
                <th>Nombre</th>
                <th>Localidad</th>
                <th>Eliminar</th>
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
                    <td style="text-align: center; vertical-align: middle">
                        <input type="checkbox"  name="deptno" value="${fila.numero}"/>
                    </td>
                </tr>
            </c:forEach> 
        </table> 
            
            <br/>
            <button type="submit">Eliminar departamentos</button>
        </form>
        
    </body>
</html>
