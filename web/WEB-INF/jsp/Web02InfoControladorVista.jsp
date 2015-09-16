<%-- 
    Document   : Web02InfoControladorVista
    Created on : 07-sep-2015, 11:46:26
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
        <h1>Enviar informacion desde el controlador a la VISTA</h1>
        <h2 style="color:blue">
            <c:out value="${saludo}"/>
        </h2>
    </body>
</html>
