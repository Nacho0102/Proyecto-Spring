package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Controller04TablaMultiplicar implements Controller
{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("Web04MostrarTablaMultiplicar");
        int numero = Integer.parseInt(hsr.getParameter("txtnumero"));
        String html = "<table border='1'>";
        for (int i = 1; i <= 10; i++)
        {
            int resultado = numero * i;
            html += "<tr>";
            html += "<td>" + numero + "*" + i + "</td>";
            html += "<th>" + resultado + "</th>";
            html += "</tr>";
        }
        html += "</table>";
        mv.addObject("tablaMultiplicar", html);
        return mv;
    }
    
}
