<%-- 
    Document   : Web08MultiplesAcciones
    Created on : 08-sep-2015, 11:22:15
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
        <h1>Múltiples Acciones en Controller</h1>
        <form action="Web08MultiplesAcciones.htm">
            <div>
                Numero 1:
                <input type="text" name="numero1"/>
            </div>
            <div>
                Numero 2:
                <input type="text" name="numero2"/>
            </div>
            <div>
                <button type="submit" name="operacion"
                        value="sumarNumeros"> 
                    Sumar números
                </button>
                <button type="submit" name="operacion"
                        value="multiplicarNumeros">
                    Multiplicar números
                </button>
            </div>
                        
                
        </form>
        
        <c:out value="${resultado}" escapeXml="false"/>
    </body>
</html>
