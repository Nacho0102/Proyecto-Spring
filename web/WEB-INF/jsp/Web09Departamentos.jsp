<%-- 
    Document   : Web09Departamentos
    Created on : 08-sep-2015, 12:22:50
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
        <h1>Consultas de accion sobre Departamentos (MultiActionController)</h1>
        <form action="Web09Departamentos.htm">
            <div>
                Número
                <input type="text" name="deptno"/>
            </div>
            <div>
                Nombre
                <input type="text" name="dnombre"/>
            </div>
            <div>
                Localidad
                <input type="text" name="loc"/>
            </div>
            <div>
                <button type="submit" name="operacion"
                        value="insertar">
                    INSERTAR
                </button>
            </div>
            <div>
                <button type="submit" name="operacion"
                        value="modificar">
                    MODIFICAR
                </button>
            </div>
        </form>
        <hr/>
        <table border="1">
            <tr>
                <th>NUMERO</th>
                <th>NOMBRE</th>
                <th>LOCALIDAD</th>
                <th>ACCION</th>
            </tr>
            <c:forEach items="${departamentos}" var="fila">
                <tr>
                    <td>
                        <c:out value="${fila.deptno}"/>
                    </td>
                    <td>
                        <c:out value="${fila.dnombre}"/>
                    </td>
                    <td>
                        <c:out value="${fila.loc}"/>
                    </td>
                    <td>
                        <a href="Web09Departamentos.htm?deptno=${fila.deptno}&operacion=eliminar">
                        Eliminar
                        </a>  
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
