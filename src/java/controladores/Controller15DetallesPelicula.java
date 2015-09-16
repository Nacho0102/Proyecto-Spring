package controladores;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.ModeloPeliculas;
import objetos.Pelicula;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Controller15DetallesPelicula implements Controller
{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("Web15DetallesPelicula");
        ModeloPeliculas modelo = new ModeloPeliculas(hsr.getServletContext());        
        if (hsr.getParameter("idpelicula") != null)
        {
            int idpelicula = 
                    Integer.parseInt(hsr.getParameter("idpelicula"));
            Pelicula peli = modelo.getPelicula(idpelicula);
            mv.addObject("pelicula", peli);
        }
        if (hsr.getParameter("comprar") != null)
        {
            int idpelicula = 
                    Integer.parseInt(hsr.getParameter("comprar"));
            ArrayList<Integer> listacompra;
            HttpSession sesion = hsr.getSession();
            if (sesion.getAttribute("CARRITO") != null)
            {
                listacompra = (ArrayList<Integer>)
                        sesion.getAttribute("CARRITO");
            }else{
                listacompra = new ArrayList();
            }
            listacompra.add(idpelicula);
            sesion.setAttribute("CARRITO", listacompra);
            Pelicula peli = modelo.getPelicula(idpelicula);
            mv.addObject("pelicula", peli);
            mv.addObject("mensaje", "Peliculas compradas: "
            + listacompra.size());
        }        
        return mv;
    }
    
}