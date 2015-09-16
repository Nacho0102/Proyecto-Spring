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
        <h1>Consultas Selección DAO</h1>
        <table border="1">
            <tr>
                <th>Número</th>
                <th>Nombre</th>
                <th>Localidad</th>
            </tr>
            <c:forEach items="${departamentos}" var="fila">
                <tr>
                    <td>
                        <c:out value="${fila.numero}"/>
                    </td>
                    <td>
                        <c:out value="${fila.nombre}"/>
                    </td>
                    <td>
                        <c:out value="${fila.localidad}"/>
                    </td>
                </tr>
            </c:forEach>        
    </body>
</html>
