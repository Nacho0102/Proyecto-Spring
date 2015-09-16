/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.DepartamentoDao;
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
public class Controller20InsertarDepartamentoDao implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        ModelAndView mv = new ModelAndView("Web20InsertarDepartamentoDao");
        DepartamentoDao deptdao
                = (DepartamentoDao) this.getBean("jdbcPrincipal", hsr.getServletContext());

        String dato = hsr.getParameter("numero");
        String nombre = hsr.getParameter("nombre");
        String localidad = hsr.getParameter("localidad");

        if (dato != null) {
            //CREAMOS EL OBJETO DEPARTAMENTO
            //QUE VAMOS A INSERTAR
            Departamento dept = new Departamento();
            int numero = Integer.parseInt(dato);
            //PASAMOS LOS VALORES AL 
            //DEPARTAMENTO PARA SU INSERCION
            dept.setNumero(numero);
            dept.setNombre(nombre);
            dept.setLocalidad(localidad);
            deptdao.insertarDepartamento(dept);

            mv.addObject("mensaje", "Departamento insertado correctamente");
        }

        List<Departamento> lista = deptdao.findAll();

        mv.addObject("departamentos", lista);

        return mv;

    }

    public Object getBean(String nombreBean, ServletContext servlet) {
        ApplicationContext contexto
                = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet);
        Object bean = contexto.getBean(nombreBean);
        return bean;
    }
}
