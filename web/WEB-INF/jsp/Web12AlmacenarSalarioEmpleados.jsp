<%-- 
    Document   : Web12AlmacenarSalarioEmpleados
    Created on : 09-sep-2015, 13:49:33
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
        <h1>Almacenar salario de empleados</h1>
        
        
        <ul>
            <c:forEach items="${empleados}" var="emp">
                
                <li>
                    <c:out value="${emp.apellido}"/>
                    <a href='Web12AlmacenarSalarioEmpleados.htm?salario=<c:out value="${emp.salario}"/>'>
                    Almacenar Salario
                    </a>
                </li>
            </c:forEach>
            
        </ul>
        
        <br/>
         <a href='Web12MostrarSalarioEmpleados.htm'>
            Ver suma salarial Session: 
        </a>
        
        <h2 style="color:blue">
            <c:out value="${mensaje}"/>
        </h2>
     
    </body>
</html>
