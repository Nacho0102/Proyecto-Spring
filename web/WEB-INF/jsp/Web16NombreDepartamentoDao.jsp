<%-- 
    Document   : Web16NombreDepartamentoDao
    Created on : 14-sep-2015, 12:07:17
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
        <h1>Buscar NOMBRE departamento DAO</h1>
        
        <form action="Web16NombreDepartamentoDao.htm">
            Introduzca un número departamento:
            <input type="text" name="numero"/>
            <button type="submit">Mostrar nombre</button>
            
        </form>
        
        <h2 style="color:blue">
            <c:out value="${mensaje}"/>
        </h2>
    </body>
</html>
