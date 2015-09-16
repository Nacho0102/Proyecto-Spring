<%-- 
    Document   : Web14ModificarDoctor
    Created on : 10-sep-2015, 12:32:31
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
        <h1>Modificar datos del doctor</h1>
        <c:set var="doctor" value="${sessionScope.controller14validar.doctor}"/>
        <form action="Web14ModificarDoctor.htm">
            <div>
                Apellido:
                <input type='text' name='apellido' 
                       value='<c:out value="${doctor.apellido}"/>'/>
            </div>
            <div>
                Hospital:
                <input type='text' name='hospitalcod' 
                       value='<c:out value="${doctor.hospitalcod}"/>'/>
            </div>            
            <div>
                Especialidad:
                <input type='text' name='especialidad' 
                       value='<c:out value="${doctor.especialidad}"/>'/>
            </div>            
            <div>
                Salario:
                <input type='text' name='salario' 
                       value='<c:out value="${doctor.salario}"/>'/>
            </div>            
            <div>
                <button type="submit">
                    Modificar datos de doctor
                </button>
            </div>
            <a href="Web14ValidarDoctor.htm">
                Volver
            </a>
        </form>
        <h3 style='color:blue'>
                <c:out value="${mensaje}"/>
        </h3>            
    </body>
</html>
