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
        <h1>Insertar departamentos DAO</h1>
        <form action="Web20InsertarDepartamentoDao.htm">
            <div>
                Número: 
                <input type="text" name="numero"/>
            </div>
            <div>
                Nombre: 
                <input type="text" name="nombre"/>
            </div>
            <div>
                Localidad: 
                <input type="text" name="localidad"/>
            </div>
            <div>
                <button type="submit" value='Insertar departamento'/>
                    Insertar departamento
                </button>
            </div>
        </form>
        <h3 style="color:blue">
            <c:out value="${mensaje}"/>
        </h3>
        <hr/>
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
        </table>           

    </body>
</html>
