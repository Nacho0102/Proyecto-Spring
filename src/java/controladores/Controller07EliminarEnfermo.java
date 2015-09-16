package controladores;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.ModeloHospital;
import objetos.Enfermo;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Controller07EliminarEnfermo implements Controller
{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("Web07EliminarEnfermo");
        ModeloHospital modelo = new ModeloHospital(hsr.getServletContext());
        if (hsr.getParameter("inscripcion") != null)
        {
            int inscripcion = 
                    Integer.parseInt(hsr.getParameter("inscripcion"));
            modelo.eliminarEnfermo(inscripcion);
        }
        ArrayList<Enfermo> lista = 
                modelo.getEnfermos();
        mv.addObject("enfermos", lista);
        return mv;
    }
    
}

