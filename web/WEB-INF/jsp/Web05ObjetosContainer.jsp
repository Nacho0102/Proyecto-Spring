<%-- 
    Document   : Web05ObjetosContainer
    Created on : 07-sep-2015, 13:59:16
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
        <h1>Recuperar objetos Spring Container</h1>
        <h1 style="color:blue">
            Marca:
            <c:out value="${coche.marca}"/>
        </h1>
        <h1 style="color:fuchsia">
            Modelo:
            <c:out value="${coche.modelo}"/>
        </h1>
        <h1 style="color:red">
            Precio:
            <c:out value="${coche.precio}"/>
        </h1>
        
    </body>
</html>
