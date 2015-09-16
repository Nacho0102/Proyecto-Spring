/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.ModeloPeliculas;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author NachoP
 */
public class Controller10Peliculas extends MultiActionController{
    
    public ModelAndView inicio (HttpServletRequest request, HttpServletResponse response) throws SQLException
    {
        ModelAndView mv = new ModelAndView("Web10MostrarPeliculas");
        ModeloPeliculas modelo = new ModeloPeliculas(request.getServletContext());
        String lista = modelo.getPeliculas();
        mv.addObject("peliculas",lista);
        
        return mv;
    }
    
     public ModelAndView argumentoPeliculas (HttpServletRequest request, HttpServletResponse response) throws SQLException
    {
        ModelAndView mv = new ModelAndView("Web10MostrarArgumentosPeliculas");
        ModeloPeliculas modelo = new ModeloPeliculas(request.getServletContext());
        int idPelicula = Integer.parseInt(request.getParameter("pelicula"));
        String lista = modelo.getArgumentoPeliculas(idPelicula);
        mv.addObject("argumento",lista);
        
        return mv;
    }
     
      public ModelAndView comprar (HttpServletRequest request, HttpServletResponse response) throws SQLException
    {
        ModelAndView mv = new ModelAndView("Web10MostrarArgumentosPeliculas");
        ModeloPeliculas modelo = new ModeloPeliculas(request.getServletContext());
        int idPelicula = Integer.parseInt(request.getParameter("pelicula"));
        String lista = modelo.comprarPelicula(idPelicula);
        mv.addObject("compra",lista);
        
        return mv;
    }
    
}
