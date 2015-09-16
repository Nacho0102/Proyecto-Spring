/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import dao.JdbcPlantillaDao;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import objetos.Plantilla;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author NachoP
 */
public class Controller23ModificarSalarioPlantilla implements Controller{

    
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        ModelAndView mv = new ModelAndView("Web23ModificarSalarioPlantilla");
        JdbcPlantillaDao jdbc = (JdbcPlantillaDao) this.getBean("jdbcPlantilla", hsr.getServletContext());
     
        List<Plantilla> lista = jdbc.findAll();
        
        if (hsr.getParameter("empno") != null) {
            String[] salario = hsr.getParameterValues("empno");
            
            for(String sal: salario)
            {
             int idsalario = Integer.parseInt(sal);
//             jdbc.modificarEmpleado(idsalario);
            }
          
        }else{
            lista = jdbc.findAll();
        }
        
        mv.addObject("plantilla", lista);
        return mv;

    }

    public Object getBean(String nombreBean, ServletContext servlet) {
        ApplicationContext contexto
                = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet);
        Object bean = contexto.getBean(nombreBean);
        return bean;
    }
}
