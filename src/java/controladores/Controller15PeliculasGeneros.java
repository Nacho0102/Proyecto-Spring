package controladores;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.ModeloPeliculas;
import objetos.Genero;
import objetos.Pelicula;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Controller15PeliculasGeneros implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("Web15PeliculasGeneros");
        ModeloPeliculas modelo = new ModeloPeliculas(hsr.getServletContext());
        ArrayList<Genero> lista = modelo.getGeneros();
        mv.addObject("generos", lista);
        if (hsr.getParameter("idgenero") != null) {
            int idgenero = Integer.parseInt(hsr.getParameter("idgenero"));
            ArrayList<Pelicula> pelis = modelo.getPeliculasGenero(idgenero);
            mv.addObject("peliculas", pelis);
        }
        return mv;
    }

}
