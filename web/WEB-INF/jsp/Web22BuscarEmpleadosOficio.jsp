
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
        <h1>Buscar Empleados Oficio DAO</h1>
              <form action="Web22BuscarEmpleadosOficio.htm">
            Introduzca un oficio: 
            <input type="text" name="oficio"/>
            <button type="submit">
                Buscar Empleados
            </button>
        </form>
        <hr/>
        <table border="1">
            <tr>
                <th>Apellido</th>
                <th>Oficio</th>
                <th>Salario</th>
                <th>Departamento</th>
            </tr>
            <c:forEach items="${empleados}" var="fila">
                <tr>
                    <td>
                        <c:out value="${fila.apellido}"/>
                    </td>
                    <td>
                        <c:out value="${fila.oficio}"/>
                    </td>
                    <td>
                        <c:out value="${fila.salario}"/>
                    </td>
                    <td>
                        <c:out value="${fila.deptno}"/>
                    </td>
                </tr>
            </c:forEach> 
        </table>        
    </body>
</html>
