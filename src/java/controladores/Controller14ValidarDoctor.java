package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.ModeloHospital;
import objetos.Doctor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Controller14ValidarDoctor implements Controller, java.io.Serializable {

    private Doctor doctor;
    private boolean existeDoctor = false;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean isExisteDoctor() {
        return existeDoctor;
    }

    public void setExisteDoctor(boolean existeDoctor) {
        this.existeDoctor = existeDoctor;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("Web14ValidarDoctor");

        
        if (hsr.getParameter("cerrar") != null)
        {
         //EL DOCTOR EXISTE
            this.doctor = null;
            mv.addObject("mensaje", "Sesión cerrada correctamente.");
        }
        
        //si el usuario es distinto de null - cogemos el usuario y password de la caja de texto
        if (hsr.getParameter("usuario") != null) {
            String apellido = hsr.getParameter("usuario");
            int doctorno = Integer.parseInt(hsr.getParameter("password"));
            ModeloHospital modelo = new ModeloHospital(hsr.getServletContext());
            this.doctor = modelo.buscarDoctor(apellido, doctorno);
            if (this.doctor == null) {
                mv.addObject("mensaje", "Usuario/Password incorrectos");
                this.existeDoctor = false;
            } else {
                this.existeDoctor = true;
            }

        } 

        return mv;
    }

}
