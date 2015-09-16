package controladores;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.ModeloHospital;
import objetos.Empleado;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Controller13ResumenEmpleados implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("Web13MostrarEmpleadoSession");
        HttpSession sesion = hsr.getSession();
        ArrayList<Integer> seleccionados;
        seleccionados = (ArrayList<Integer>)sesion.getAttribute("EMPLEADOS");
        if (hsr.getParameter("eliminar") != null)
        {
            int empno = Integer.parseInt(hsr.getParameter("eliminar"));
            seleccionados.remove((Integer)empno);
            if (seleccionados.isEmpty())
            {
                seleccionados = null;
                sesion.setAttribute("EMPLEADOS", null);
            }
        }
        
        if (seleccionados != null)
        {
            ModeloHospital modelo = new ModeloHospital(hsr.getServletContext());
            ArrayList<Empleado> lista = modelo.getEmpleados(seleccionados);
            mv.addObject("empleados", lista);
        }else{
            mv.addObject("mensaje", "No hay empleados almacenados");
        }
        return mv;
    }
}
