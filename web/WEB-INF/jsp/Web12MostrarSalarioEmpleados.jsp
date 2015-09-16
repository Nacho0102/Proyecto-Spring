<%-- 
    Document   : Web12MostrarSalarioEmpleados
    Created on : 09-sep-2015, 13:49:43
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
        <h1>Mostrar suma salarial Session</h1>
        
        <c:choose>
            <c:when test="${not empty sessionScope.SUMASALARIAL}">
                <h2 style="color:blue">
                    La suma salarial de los empleados de Session es:
                    <c:out value="${sessionScope.SUMASALARIAL}"/>
                </h2>
            </c:when>
            <c:otherwise>
                <h3 style="color:red">
                    No se ha almacenado ningun salario todavia
                </h3>
            </c:otherwise>
        </c:choose>
        
        
        <a href="Web12AlmacenarSalarioEmpleados.htm">
            
            Volver a Almacenar salario Session
        </a>
        
        
    </body>
</html>
