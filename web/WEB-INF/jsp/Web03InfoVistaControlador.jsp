<%-- 
    Document   : Web03InfoVistaControlador
    Created on : 07-sep-2015, 12:02:28
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
        <h1>Enviar informacion desde la vista al controlador</h1>
        <form action="Web03InfoVistaControlador.htm">
            
            <!--el action en el form, para que llegue la informacion al controlador-->
            
            <div>
                Nombre:
                <input type="text" name="txtnombre"/>
            </div>
                
            <div>
                Edad:
                <input type="text" name="txtedad"/>
            </div>
            <div>
                <button type="submit">Enviar informacion</button>
            </div>
        </form>
        
<!--        Pintar un objeto con jstl-->
        <c:if test="${not empty persona}">
            <h1 style="color:red">
                Datos recibidos!!!
                
            </h1>
            <h2>
                Nombre:
                <c:out value="${persona.nombre}"/>
                
            </h2>
                
             <h2>
                Edad:
                <c:out value="${persona.edad}"/>
                
            </h2>  
            
        </c:if>
        
        
        
       
    </body>
</html>
