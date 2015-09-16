<%-- 
    Document   : Web10MosrtrarArgumentosPeliculas
    Created on : 09-sep-2015, 9:43:27
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
        <h1>Argumentos de la pelicula</h1>
        <form>
            
            <c:out value="${argumento}"
                   escapeXml="false"/>
               
        </form>
        
             <c:out value="${compra}"
                   escapeXml="false"/>
    </body>
</html>
