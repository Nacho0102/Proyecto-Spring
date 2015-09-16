package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.ModeloHospital;
import objetos.Doctor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Controller14ModificarDoctor implements Controller
{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("Web14ModificarDoctor");
        if (hsr.getParameter("apellido") != null)
        {
            //CAPTURAR LAS VARIABLES QUE VIENEN
            //EN EL REQUEST
            String apellido = hsr.getParameter("apellido");
            int hospitalcod = 
                    Integer.parseInt(hsr.getParameter("hospitalcod"));
            String especialidad = hsr.getParameter("especialidad");
            int salario = 
                    Integer.parseInt(hsr.getParameter("salario"));
            //RECUPERAR EL DOCTOR QUE EXISTE
            //EN SESSION
            HttpSession sesion = hsr.getSession();
            Controller14ValidarDoctor c =
                    (Controller14ValidarDoctor)
                    sesion.getAttribute("controller14validar");
            
            //c.setDoctor(null);
            
            Doctor doc = c.getDoctor();
            //MODIFICAR LOS DATOS DEL DOCTOR SESSION
            //CON LOS DATOS RECIBIDOS EN REQUEST
            doc.setApellido(apellido);
            doc.setHospitalcod(hospitalcod);
            doc.setEspecialidad(especialidad);
            doc.setSalario(salario);
            //MODIFICAMOS LA BASE DE DATOS
            ModeloHospital modelo = new ModeloHospital(hsr.getServletContext());
            modelo.modificarDoctor(doc);
            mv.addObject("mensaje", "Datos modificados correctamente.");
        }
        return mv;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
