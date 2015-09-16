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
public class Controller13AlmacenarEmpleados implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        ModelAndView mv = new ModelAndView("Web13AlmacenarEmpleadoSession");
//        ModeloHospital modelo = new ModeloHospital(hsr.getServletContext());
//        ArrayList<Empleado> lista = modelo.getEmpleados();
//        if (hsr.getParameter("contador") != null) {
//            int contador = Integer.parseInt(hsr.getParameter("contador"));
//
//            int sumaEmpleado = 0;
//            HttpSession sesion = hsr.getSession();
//            if (sesion.getAttribute("SUMAEMPLEADO") != null) {
//                sumaEmpleado = Integer.parseInt(sesion.getAttribute("SUMAEMPLEADO").toString());
//            }
//            sumaEmpleado += contador;
//            mv.addObject("mensaje", "Numero de empleados almacenados: " + sumaEmpleado);
//            sesion.setAttribute("SUMAEMPLEADO", sumaEmpleado);
//        }
//
//        ArrayList<Empleado> listaempleados = new ArrayList();
//        if (hsr.getParameter("empleado") != null) {
//            int empno = Integer.parseInt(hsr.getParameter("empleado"));
//            HttpSession sesion = hsr.getSession();
//            if (sesion.getAttribute("EMPLEADO") != null) {
//                for (Empleado emp : (ArrayList<Empleado>) sesion.getAttribute("EMPLEADO")) {
//                    listaempleados.add(emp);
//                }
//            }
//            listaempleados.add(modelo.getEmpleado(empno));
//
//            sesion.setAttribute("EMPLEADO", listaempleados);
//
//        }
//
//        mv.addObject("EMPLEADO", listaempleados);
//        mv.addObject("empleados", lista);
//        return mv;
//
//    }
        
        ModeloHospital modelo = new ModeloHospital(hsr.getServletContext());
        ArrayList<Empleado> lista = modelo.getEmpleados();
        mv.addObject("empleados", lista);
        if (hsr.getParameter("empno") != null)
        {
            int empno = Integer.parseInt(hsr.getParameter("empno"));
            ArrayList<Integer> empleados;
            HttpSession sesion = hsr.getSession();
            if (sesion.getAttribute("EMPLEADOS") != null)
            {
                empleados = (ArrayList<Integer>)sesion.getAttribute("EMPLEADOS");
            }else{
                empleados = new ArrayList();
            }
            empleados.add(empno);
            sesion.setAttribute("EMPLEADOS", empleados);
            mv.addObject("mensaje", "Empleado almacenado: " + empno);
        }
        return mv;
    }

}
