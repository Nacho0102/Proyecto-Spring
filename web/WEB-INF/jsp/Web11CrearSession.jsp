<%-- 
    Document   : Web11CrearSession
    Created on : 09-sep-2015, 12:17:44
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
        <h1>Crear objeto Sesion</h1>
        
        <form action="Web11CrearSession.htm">
            <div>
                Nombre:
                <input type="text" name="nombre"/>
                
            </div>
            
            
            <div>
                Edad:
                <input type="text" name="edad"/>
            </div>
            <div>
                <button type="submit"> 
                    Crear objeto en Session
                </button>
            </div>

        </form>
        
        <h2 style="color:blue">
            <c:out value="${mensaje}"/>
        </h2>
        
        <a href="Web11MostrarSession.htm">
            Mostrar datos almacenados en Session
        </a>
        
    </body>
</html>
