<%-- 
    Document   : Web13MostrarEmpleadoSession
    Created on : 10-sep-2015, 8:47:54
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
         <h1>Resumen de empleados</h1>
        <h3 style='color:red'>
            <c:out value="${mensaje}"/>
        </h3>
        <dl>
            <c:forEach items="${empleados}" var="fila">
                <dt>
                <b>
                    <c:out value="${fila.apellido}"/>
                </b>
                </dt>
                <dd>
                    <c:out value="${fila.oficio}"/>
                </dd>
                <dd>
                    <a href='Web13MostrarEmpleadoSession.htm?eliminar=<c:out value="${fila.empno}"/>'>
                        Quitar de la sesión
                    </a>
                </dd>
            </c:forEach>
        </dl>
        <a href='Web13AlmacenarEmpleadoSession.htm'>
            Volver
        </a>
    </body>
</html>
