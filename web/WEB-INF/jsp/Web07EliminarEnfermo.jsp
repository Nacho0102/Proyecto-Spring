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
        <h1>Eliminar enfermos con Spring</h1>
        <form action="Web07EliminarEnfermo.jsp">
            <div>
                Inscripción:
                <input type="text" name="inscripcion"/>
                <button type="submit">
                    Eliminar enfermo
                </button>
            </div>
        </form>
        <hr/>
        <table border="1">
            <tr>
                <th>INSCRIPCION</th>
                <th>APELLIDO</th>
                <th>DIRECCION</th>
                <th>FECHA NACIMIENTO</th>
            </tr>
            <c:forEach items="${enfermos}" var="fila">
                <tr>
                    <td>
                        <c:out value="${fila.inscripcion}"/>
                    </td>
                    <td>
                        <c:out value="${fila.apellido}"/>
                    </td>
                    <td>
                        <c:out value="${fila.direccion}"/>
                    </td>
                    <td>
                        <c:out value="${fila.fechaNacimiento}"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>