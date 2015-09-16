/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import static com.sun.codemodel.JOp.ne;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetos.Persona;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author NachoP
 */
public class Controller11CrearSession implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        ModelAndView mv = new ModelAndView("Web11CrearSession");
        if(hsr.getParameter("nombre") != null)
        {
            String nombre = hsr.getParameter("nombre");
            int edad = Integer.parseInt(hsr.getParameter("edad"));
            //recupero el objeto session
            HttpSession sesion = hsr.getSession();
            //Guarda algo en la sesion
            sesion.setAttribute("NOMBRE", nombre);
            Persona p = new Persona();
            p.setNombre(nombre);
            p.setEdad(edad);
            sesion.setAttribute("PERSONA", p);
            
            mv.addObject("mensaje", "Datos guardados en Session correctamente");
            
        }
        return mv;
        
    }
    
    
    
}
