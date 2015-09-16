/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.ModeloHospital;
import objetos.Departamento;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author NachoP
 */
public class Controller09Departamentos extends MultiActionController {

    public ModelAndView inicio(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ModelAndView mv = new ModelAndView("Web09Departamentos");
        ModeloHospital modelo = new ModeloHospital(request.getServletContext());
        ArrayList<Departamento> lista;
        lista = modelo.getDepartamentos();
        mv.addObject("departamentos", lista);
        return mv;

    }

    public ModelAndView insertar(HttpServletRequest request, HttpServletResponse response) throws SQLException {

       
        
        
        ModelAndView mv = new ModelAndView("Web09Departamentos");
        ModeloHospital modelo = new ModeloHospital(request.getServletContext());

        int deptno = Integer.parseInt(request.getParameter("deptno"));
        String dnombre = request.getParameter("dnombre");
        String loc = request.getParameter("loc");

        modelo.insertarDepartamento(deptno, dnombre, loc);

        ArrayList<Departamento> lista;
        lista = modelo.getDepartamentos();
        mv.addObject("departamentos", lista);

        return mv;

    }

    public ModelAndView modificar(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        ModelAndView mv = new ModelAndView("Web09Departamentos");
        ModeloHospital modelo = new ModeloHospital(request.getServletContext());

        int deptno = Integer.parseInt(request.getParameter("deptno"));
        String dnombre = request.getParameter("dnombre");
        String loc = request.getParameter("loc");

        modelo.modificarDepartamentos(deptno, dnombre, loc);

        ArrayList<Departamento> lista;
        lista = modelo.getDepartamentos();
        mv.addObject("departamentos", lista);

        return mv;
    }
    
    public ModelAndView eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        ModelAndView mv = new ModelAndView("Web09Departamentos");
        ModeloHospital modelo = new ModeloHospital(request.getServletContext());

        int deptno = Integer.parseInt(request.getParameter("deptno"));
        

        modelo.eliminarDepartamento(deptno);

        ArrayList<Departamento> lista;
        lista = modelo.getDepartamentos();
        mv.addObject("departamentos", lista);

        return mv;
    }
}
