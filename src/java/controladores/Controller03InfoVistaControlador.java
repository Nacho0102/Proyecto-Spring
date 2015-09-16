/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objetos.Persona;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author NachoP
 */
public class Controller03InfoVistaControlador implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
      
        ModelAndView mv = new ModelAndView("Web03InfoVistaControlador");
        if(hsr.getParameter("txtnombre") != null)
        {       
        
        //Recuperamos los parametros de la llamada
        String nombre = hsr.getParameter("txtnombre");
        int edad = Integer.parseInt(hsr.getParameter("txtedad"));
        //Creamos un objeto persona y lo devolvemos a la vista
        Persona p = new Persona();
        p.setNombre(nombre);
        p.setEdad(edad);
        mv.addObject("persona", p);
//        "persona" es un alias para pintarlo en la vista
        
        }
        return mv;
        
    }
    
}
