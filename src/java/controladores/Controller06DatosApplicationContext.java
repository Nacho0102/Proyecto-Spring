/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.ModeloHospital;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author NachoP
 */
public class Controller06DatosApplicationContext implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        ModeloHospital modelo = new ModeloHospital(hsr.getServletContext());
        ArrayList<String> lista = modelo.getApellidoEmpleados();
        ModelAndView mv = new ModelAndView("Web06DatosApplicationContext");
        mv.addObject("apellidos",lista);
        return mv;
    }
    
}
