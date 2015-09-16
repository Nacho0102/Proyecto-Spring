<%-- 
    Document   : Web06DatosApplicationContext
    Created on : 08-sep-2015, 8:26:42
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
        <h1>Acceso a datos con Application Context JDBC</h1>
        <ul>
            <c:forEach items="${apellidos}" var="apellido">
                <li>
                    <c:out value="${apellido}"/>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
