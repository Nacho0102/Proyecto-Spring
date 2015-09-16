<%-- 
    Document   : Web14ValidarDoctor
    Created on : 10-sep-2015, 12:32:11
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
        <h1>Validar doctor</h1>
        
        <form action="Web14ValidarDoctor.htm">
            <div>
                Usuario:
                <input type='text' name='usuario'/>
            </div>
            <div>
                Password:
                <input type='text' name='password'/>
            </div>
            <div>
                <button type='submit'>
                    Validar doctor
                </button>
            </div>
        </form>
        
        <c:if test="${sessionScope.controller14validar.doctor != null}">
            <hr/>    
            <c:set var="doctor" 
                   value="${sessionScope.controller14validar.doctor}"/>
            <dl>
                <dt><b>
                    <c:out value="${doctor.apellido}"/>
                </b></dt>
                <dd>
                    Hospital: <c:out value="${doctor.hospitalcod}"/>
                </dd>
                <dd>
                    Especialidad: <c:out value="${doctor.especialidad}"/>
                </dd>
                <dd>
                    Salario: <c:out value="${doctor.salario}"/>
                </dd>
            </dl>
            <a href='Web14ModificarDoctor.htm'>
                    Modificar datos de doctor
            </a>
                
            <br/>
            
            <a href='Web14ValidarDoctor.htm?cerrar=1'>
                Cerrar sesión
            </a>
                
        </c:if>
            <h3 style='color:red'>
                <c:out value="${mensaje}"/>
            </h3>
    </body>
</html>
