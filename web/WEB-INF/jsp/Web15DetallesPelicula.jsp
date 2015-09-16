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
        <h1>Detalles de la pelicula</h1>
        <dl>
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
            <a href='Web15DetallesPelicula.htm?comprar=<c:out value="${pelicula.idpelicula}"/>'>
                Comprar pelicula
            </a>
            </dd>                    
            <dd>
                <a href='Web15PeliculasGeneros.htm?idgenero=<c:out value="${pelicula.idgenero}"/>'>
                    Volver
                </a>
            </dd>
        </dl>  
        <h3 style='color:blue'>
            <c:out value="${mensaje}"/>
        </h3>
    </body>
</html>
