/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.ModeloHospital;
import objetos.Empleado;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author NachoP
 */
public class Controller12AlmacenarSalarioEmpleados implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
     
        ModelAndView mv = new ModelAndView("Web12AlmacenarSalarioEmpleados");
        ModeloHospital modelo = new ModeloHospital(hsr.getServletContext());
        ArrayList<Empleado> lista = modelo.getEmpleados();
        if(hsr.getParameter("salario")!=null)
        {
            int salario = Integer.parseInt(hsr.getParameter("salario"));
            mv.addObject("mensaje","Salario almacenado correctamente: " +salario);
            
            int sumaSalarial = 0;
            //capturar la session
            HttpSession sesion = hsr.getSession();
            if(sesion.getAttribute("SUMASALARIAL") != null)
            {
                //SI EXISTE, RECUPERAMOS EL VALOR
                    //DE LA SUMA SALARIAL DE LA SESION
                
                sumaSalarial = Integer.parseInt(sesion.getAttribute("SUMASALARIAL").toString());
                
                
            }
            
            //ALMACENAMOS EL NUEVO VALOR DEL SALARIO DENTO DE LA 
            //INFORMACION DE SUMASALARIAL
            
            sumaSalarial += salario;
            //GUARDAMOS EL NUEVO VALOR DE SUMASALARIAL DENTRO DE LA SESION
            sesion.setAttribute("SUMASALARIAL", sumaSalarial);
        }
        
        
        mv.addObject("empleados", lista);
        return mv;
        
    }

    
    
            

    
    
}
