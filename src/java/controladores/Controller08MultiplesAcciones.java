/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver;

/**
 *
 * @author NachoP
 */
public class Controller08MultiplesAcciones extends MultiActionController{
    
    
    public ModelAndView inicio(HttpServletRequest request,HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView("Web08MultiplesAcciones");
        return mv;
    }
    
    
    public ModelAndView sumarNumeros (HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView("Web08MultiplesAcciones");
        int num1 = Integer.parseInt(request.getParameter("numero1"));
        int num2 = Integer.parseInt(request.getParameter("numero2"));
        int resultado = num1 + num2;
        mv.addObject("resultado","<h2 style='color:red'>"
                + "La SUMA de los numero es: "
                + resultado
                + "</h2>");
        return mv;
    }
    
     public ModelAndView multiplicarNumeros (HttpServletRequest request, HttpServletResponse response)
    {
                
        ModelAndView mv = new ModelAndView("Web08MultiplesAcciones");
        int num1 = Integer.parseInt(request.getParameter("numero1"));
        int num2 = Integer.parseInt(request.getParameter("numero2"));
        int resultado = num1 * num2;
        mv.addObject("resultado","<h2 style='color:blue'>"
                + "La MULTIPLICACION de los numero es: "
                + resultado
                + "</h2>");
        return mv;
    }
    
}
