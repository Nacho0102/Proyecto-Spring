/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.JdbcEmpleadoDao;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Empleado;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author NachoP
 */
public class Controller22BuscarEmpleadosOficio implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
        List<Empleado> lista;
        ModelAndView mv = new ModelAndView("Web22BuscarEmpleadosOficio");
        JdbcEmpleadoDao jdbc = (JdbcEmpleadoDao) this.getBean("jdbcEmpleados", hsr.getServletContext());
        if (hsr.getParameter("oficio") != null) {
            String oficio = hsr.getParameter("oficio");
            
            lista = jdbc.findByOficio(oficio);
          
        }else{
            lista = jdbc.findAll();
        }
        
        mv.addObject("empleados", lista);
        return mv;

    }

    public Object getBean(String nombreBean, ServletContext servlet) {
        ApplicationContext contexto
                = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet);
        Object bean = contexto.getBean(nombreBean);
        return bean;
    }
}
