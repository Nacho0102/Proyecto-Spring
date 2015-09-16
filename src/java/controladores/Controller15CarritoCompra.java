package controladores;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.ModeloPeliculas;
import objetos.Pelicula;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Controller15CarritoCompra implements Controller
{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("Web15CarritoCompra");
        HttpSession sesion = hsr.getSession();
        
        ArrayList<Integer> listacompra;
        if (hsr.getParameter("eliminar") != null)
        {
            int idpelicula = Integer.parseInt(hsr.getParameter("eliminar"));
            listacompra = (ArrayList<Integer>)
                    sesion.getAttribute("CARRITO");
            listacompra.remove((Integer)idpelicula);
            if (listacompra.isEmpty())
            {
                sesion.setAttribute("CARRITO", null);
            }
        }
        
        if (sesion.getAttribute("CARRITO") != null)
        {
            ModeloPeliculas modelo = new ModeloPeliculas(hsr.getServletContext());
            ArrayList<Integer> compra = (ArrayList<Integer>)
                    sesion.getAttribute("CARRITO");
            ArrayList<Pelicula> lista = modelo.getPeliculasCarrito(compra);
            mv.addObject("peliculas", lista);
        }else{
            mv.addObject("mensaje", "No hay peliculas en el carrito.");
        }
        return mv;
    }
    
}