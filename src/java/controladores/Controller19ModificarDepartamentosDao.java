/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.JdbcDepartamentoDao;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Departamento;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author NachoP
 */
public class Controller19ModificarDepartamentosDao implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        ModelAndView mv = new ModelAndView("Web19ModificarDepartamentosDao");
        JdbcDepartamentoDao jdbc = (JdbcDepartamentoDao)this.getBean("jdbcPrincipal",hsr.getServletContext());
        if(hsr.getParameter("numero") != null)
        {
            int numero = Integer.parseInt(hsr.getParameter("numero"));
            String nombre = hsr.getParameter("nombre");
            String localidad = hsr.getParameter("localidad");
            Departamento d = new Departamento();
            d.setNumero(numero);
            d.setNombre(nombre);
            d.setLocalidad(localidad);
            jdbc.modificarDepartamento(d);
            mv.addObject("mensaje","Departamento modificado correctamente.");
        }
        List<Departamento> lista = jdbc.findAll();
        mv.addObject("departamentos",lista);
        return mv;
    }
    
    
    
    public Object getBean(String nombreBean
    , ServletContext servlet)
    {
        ApplicationContext contexto = 
        WebApplicationContextUtils.getRequiredWebApplicationContext(servlet);
        Object bean = contexto.getBean(nombreBean);
        return bean;
    }     
    
}
