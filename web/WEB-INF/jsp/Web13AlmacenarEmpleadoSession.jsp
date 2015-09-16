<%-- 
    Document   : Web13AlmacenarEmpleadoSession
    Created on : 10-sep-2015, 8:47:34
    Author     : NachoP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" 
          prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body>
        <h1>Almacenar empleados</h1>
        <h3 style='color:blue'>
            <c:out value="${mensaje}"/>
        </h3>
        <ul>
            <c:set var="seleccionados" value="${sessionScope.EMPLEADOS}" />
            <c:forEach items="${empleados}" var="fila">
                <li>
                    <c:out value="${fila.apellido}"/>
                    <c:choose>
                        <c:when test="${seleccionados.contains(fila.empno)}">
                            <img src='imagenes/ok.jpg'
                                 style="width:32px;height: 32px"/>
                        </c:when>
                        <c:otherwise>
                            <a href='Web13AlmacenarEmpleadoSession.htm?empno=<c:out value="${fila.empno}"/>'>
                                Almacenar
                            </a>                            
                        </c:otherwise>
                    </c:choose>
                </li>
            </c:forEach>
        </ul>
           <h2 style='color:red'>
            Número de empleados almacenados: 
            <c:out value="${seleccionados.size()}"/>
        </h2>
        <br/>
        <a href='Web13MostrarEmpleadoSession.htm'>
            Resumen de empleados
        </a>
    </body>
</html>
