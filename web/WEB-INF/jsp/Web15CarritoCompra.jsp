<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"
          prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Carrito de la compra</h1>
        <h3 style='color:blue'>
            Peliculas compradas: 
            <c:choose>
                <c:when test="${sessionScope.CARRITO == null}">
                    0
                </c:when>
                <c:otherwise>
                    <c:out value="${sessionScope.CARRITO.size()}"/>
                </c:otherwise>
            </c:choose>
        </h3>
        <h3 style='color:red'>
            <c:out value="${mensaje}"/>
        </h3>
        <c:if test="${not empty peliculas}">
                <dl>
                    <c:forEach items="${peliculas}" var="pelicula">
                        <dt><b>
                            <c:out value="${pelicula.titulo}"/>
                        </b>
                        <img src='carteles/<c:out value="${pelicula.foto}"/>'
                             style='width: 50px; height: 70px'/>
                        </dt>
                        <dd>
                            <c:out value="${pelicula.precio}"/>€
                        </dd>
                        <dd>
                            <a href='Web15CarritoCompra.htm?eliminar=<c:out value="${pelicula.idpelicula}"/>'>
                                Eliminar
                            </a>
                        </dd>                    
                        <dd>
                            <a href='Web15DetallesPelicula.htm?idpelicula=<c:out value="${pelicula.idpelicula}"/>'>
                                Detalles
                            </a>
                        </dd>
                    </c:forEach>                    
                </dl>
        </c:if>  
        <a href='Web15PeliculasGeneros.htm'>
            Ir a generos
        </a>
    </body>
</html>