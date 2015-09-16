<%-- 
    Document   : Web10MostrarPeliculas
    Created on : 09-sep-2015, 9:04:25
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
        <h1>Peliculas con MULTIACTIONCONTROLLER</h1>
        
        <form action="Web10MostrarPeliculas.jsp">
            
            <c:out value="${peliculas}"
                   escapeXml="false"/>
        </form>
        
    </body>
</html>
