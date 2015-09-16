/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.JdbcClientesDaoSupport;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Cliente;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author NachoP
 */
public class Controller24ClientesDaoSupport implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        ModelAndView mv = new ModelAndView("Web24ClientesDaoSupport");
        JdbcClientesDaoSupport jdbc = (JdbcClientesDaoSupport) this.getBean("jdbcClientes", hsr.getServletContext());

        if (hsr.getParameter("idcliente") != null) {
            
            int idcliente = Integer.parseInt(hsr.getParameter("idcliente"));
            String nombre = hsr.getParameter("nombre");
            String direccion = hsr.getParameter("direccion");
            jdbc.insertarCliente(idcliente, nombre, direccion);
        }

        List<Cliente> lista = jdbc.getClientes();
        mv.addObject("clientes", lista);
        return mv;

    }

    public Object getBean(String nombreBean, ServletContext servlet) {
        ApplicationContext contexto
                = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet);
        Object bean = contexto.getBean(nombreBean);
        return bean;
    }

}
