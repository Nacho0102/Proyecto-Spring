<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"
          prefix="c" %>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Peliculas por genero</h1>
        <a href='Web15CarritoCompra.htm'>
            Finalizar compra
        </a>
        <div style='float:left'>
            <ul class="nav nav-pills nav-stacked">
                <c:forEach items="${generos}" var="genero">
                    <li  class="dropdown">
                        <a href='Web15PeliculasGeneros.htm?idgenero=<c:out value="${genero.idgenero}"/>'>
                            <c:out value="${genero.genero}"/>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>            
        <div style='float:left'>
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
                            <a href='Web15DetallesPelicula.htm?idpelicula=<c:out value="${pelicula.idpelicula}"/>&idgenero=<c:out value="${pelicula.idgenero}"/>'>
                                Detalles
                            </a>
                        </dd>                    
                    </c:forEach>                    
                </dl>
            </c:if>
        </div>
    </body>
</html>


