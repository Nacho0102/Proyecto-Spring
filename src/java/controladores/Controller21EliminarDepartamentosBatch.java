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
public class Controller21EliminarDepartamentosBatch implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        ModelAndView mv = new ModelAndView("Web21EliminarDepartamentosBatch");
        JdbcDepartamentoDao modelo = (JdbcDepartamentoDao)
                this.getBean("jdbcPrincipal",hsr.getServletContext());
        
        if(hsr.getParameter("deptno")!= null)
        {
            String[] departamentos = hsr.getParameterValues("deptno");
            for(String num: departamentos)
            {
                int iddepartamento = Integer.parseInt(num);
                modelo.eliminarDepartamento(iddepartamento);
                
            }
            mv.addObject("mensaje","Departamentos eliminados: " + departamentos.length);
        }
       
        List<Departamento> lista = modelo.findAll();
        mv.addObject("departamentos",lista);
        return mv;
        
    }
    
    
     public Object getBean(String nombreBean, ServletContext servlet)
    {
        ApplicationContext contexto = 
        WebApplicationContextUtils.getRequiredWebApplicationContext(servlet);
        Object bean = contexto.getBean(nombreBean);
        return bean;
    }     
}
