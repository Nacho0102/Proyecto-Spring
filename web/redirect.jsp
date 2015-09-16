<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ol>
    <li>
        <a href="Web01PrimeraVista.htm">
            Primera Vista de Spring
        </a>
    </li>
    <li>
        <a href="Web02InfoControladorVista.htm">
            Información Controlador Vista
        </a>
    </li>
    <li>
        <a href="Web03InfoVistaControlador.htm">
            Información Vista Controlador
        </a>
    </li>
    <li>
        <a href="Web04PedirNumero.htm">
            Tabla de multiplicar con dos páginas
        </a>
    </li>
     <li>
        <a href="Web05ObjetosContainer.htm">
            Recuperar objstos Application Context
        </a>
    </li>
    <li>
        <a href="Web06DatosApplicationContext.htm">
            Acceso a datos con JDBC Spring Container
        </a>
    </li>
    <li>
        <a href="Web07EliminarEnfermo.htm">
            Eliminar Enfermos JDBC
        </a>
    </li>
    <li>
        <a href="Web08MultiplesAcciones.htm?operacion=inicio">
            Múltiples Acciones en Controller
        </a>
    </li>
    <li>
        <a href="Web09Departamentos.htm?operacion=inicio">
            Múltiples Acciones en Departamentos
        </a>
    </li>
    
    <li>
        <a href="Web10MostrarPeliculas.htm?operacion=inicio">
            Múltiples Acciones en Peliculas
        </a>
    </li>
    
    <li>
        <a href="Web11CrearSession.htm">
            Objetos Session con Spring
        </a>
    </li>
 
     <li>
        <a href="Web12AlmacenarSalarioEmpleados.htm">
            Almacenar salario empleados Session
        </a>
    </li>
     <li>
        <a href="Web13AlmacenarEmpleadoSession.htm">
            Almacenar empleados Session
        </a>
    </li>
    
     <li>
        <a href="Web14ValidarDoctor.htm">
            Validar doctor Session
        </a>
    </li>
     <li>
        <a href='Web15PeliculasGeneros.htm'>
            Carrito de la compra peliculas
        </a>
    </li>    
    
 
     <li>
        <a href='Web16NombreDepartamentoDao.htm'>
            Buscar NOMBRE Departamento DAO
        </a>
    </li>    
    
     <li>
        <a href='Web17ConsultaSeleccionDao.htm'>
            Consultas de Seleccion DAO
        </a>
    </li>  
    
    <li>
        <a href='Web18ConsultasParametrizadas.htm'>
            Consultas parametrizadas Spring DAO
        </a>
    </li>  
     <li>
        <a href='Web19ModificarDepartamentosDao.htm'>
            Modificar Departamento Spring DAO
        </a>
    </li>  
    
     <li>
        <a href='Web20InsertarDepartamentoDao.htm'>
            Insertar Departamento Spring DAO
        </a>
    </li>  
    
    <li>
        <a href='Web21EliminarDepartamentosBatch.htm'>
            Eliminar Departamento Batch Spring DAO
        </a>
    </li>  
    
    <li>
        <a href='Web22BuscarEmpleadosOficio.htm'>
            Buscar empleados oficio DAO
        </a>
    </li> 
    
    <li>
        <a href='Web23ModificarSalarioPlantilla.htm'>
           Modificar Salario Plantilla DAO
        </a>
    </li> 
     <li>
        <a href='Web24ClientesDaoSupport.htm'>
           Insertar Clientes JdbcDaosupport
        </a>
    </li> 
</ol>