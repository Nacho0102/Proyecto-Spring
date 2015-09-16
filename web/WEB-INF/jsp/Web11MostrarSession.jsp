<%-- 
    Document   : Web11MostrarSession
    Created on : 09-sep-2015, 12:17:58
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
        <h1>Mostrar datos almacenados en Session</h1>
        
        <c:choose>
            <c:when test="${not empty sessionScope.NOMBRE}">
                <h2 style="color:blue">
                    El nombre almacenado en Session es:
                    <c:out value="${sessionScope.NOMBRE}"/>
                </h2>    
                
                <h1 style="color:fuchsia">
                  
                    Datos almacenados de Persona:
                    Nombre:
                    <c:out value="${sessionScope.PERSONA.nombre}"/>
                    , Edad:
                    <c:out value="${sessionScope.PERSONA.edad}"/>
                </h1>
                </c:when>
            <c:otherwise>
                <h2 style="color:red">
                    No hay datos almacenados en la session
                </h2>
            </c:otherwise>
        </c:choose>
        <a href="Web11CrearSession.htm">Volver....</a>
        
    </body>
</html>
