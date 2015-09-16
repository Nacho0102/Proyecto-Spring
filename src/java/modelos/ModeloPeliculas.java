/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import objetos.Genero;
import objetos.Pelicula;
import oracle.jdbc.OracleDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author NachoP
 */
public class ModeloPeliculas {

    private ServletContext servlet;
    private Connection cn;
    private CachedRowSet crs;

    public ModeloPeliculas(ServletContext src) {
        this.servlet = src;
    }

    private Object getBean(String nombreBean) {
        ApplicationContext contexto = WebApplicationContextUtils.getRequiredWebApplicationContext(this.servlet);
        Object bean = contexto.getBean(nombreBean);
        return bean;
    }

    public void conectarSQL() throws SQLException {
        DriverManager.registerDriver(new SQLServerDriver());
        this.crs = RowSetProvider.newFactory().createCachedRowSet();
        this.crs.setUrl("jdbc:sqlserver://LOCALHOST:1433;databaseName=PELICULAS_NACHO");
        this.crs.setUsername("SA");
        this.crs.setPassword("");
    }

    public String getPeliculas() throws SQLException {
        //Como conectar un cursor de salida
        this.conectarSQL();
        String consulta = "select * from peliculas";
        this.crs.setCommand(consulta);

        this.crs.execute();
        this.crs.beforeFirst();

        String html = "<table border='1' style='width:auto'> ";
        html += "<tr>";
        html += "<th>TITULO</th>";
        html += "<th>DIRECTOR</th>";
        html += "<th>CARTEL</th>";
        html += "<th>PRECIO</th>";
        html += "<th>VER DETALLES</th>";
        html += "<th>COMPRAR</th>";
        html += "</tr>";
        while (crs.next()) {
            html += "<tr>";
            html += "<td>";
            html += crs.getString("TITULO");
            html += "</td>";

            html += "<td>";
            html += crs.getString("DIRECTOR");
            html += "</td>";

            html += "<td><img width='104' height='142' src='/ProyectoSpring/carteles/";
            html += crs.getString("FOTO");
            html += "'/></td>";

            html += "<td>";
            html += crs.getString("PRECIO");
            html += "</td>";

            html += "<td>"
                    + "<a href='Web10MostrarArgumentosPeliculas.htm?pelicula="
                    + crs.getString("IDPELICULA")
                    + "&operacion=argumentoPeliculas'>Ver más</a>"
                    + "</td>";

            html += "<td><a href='Web10MostrarPeliculas.htm?pelicula="
                    + crs.getString("IDPELICULA")
                    + "&operacion=comprar'>Comprar Pelicula</a></td>";
            html += "</tr>";

        }
        html += "</table>";

//        
        return html;

    }

    public String getArgumentoPeliculas(int idpelicula) throws SQLException {
        //Como conectar un cursor de salida
        this.conectarSQL();
        String consulta = "SELECT * FROM PELICULAS WHERE IDPELICULA = ?";
        this.crs.setCommand(consulta);
        this.crs.setInt(1, idpelicula);
        this.crs.execute();
        this.crs.beforeFirst();

        //El cursor devuelve un RESULTSET
        String html = "<table border='1' style='width:auto'> ";
        html += "<tr>";
        html += "<th>TITULO</th>";
        html += "<th>DIRECTOR</th>";
        html += "<th>CARTEL</th>";
        html += "<th>PRECIO</th>";
        html += "<th>ARGUMENTO</th>";
        html += "<th>COMPRAR</th>";
        html += "</tr>";
        while (this.crs.next()) {
            html += "<tr>";
            html += "<td>";
            html += this.crs.getString("TITULO");
            html += "</td>";

            html += "<td>";
            html += crs.getString("DIRECTOR");
            html += "</td>";

            html += "<td><img width='104' height='142' src='/ProyectoSpring/carteles/";
            html += crs.getString("FOTO");
            html += "'/></td>";

            html += "<td>";
            html += crs.getString("PRECIO");
            html += "</td>";

            html += "<td>";
            html += crs.getString("ARGUMENTO");
            html += "</td>";

            html += "<td><a href='Web10MostrarArgumentosPeliculas.htm?pelicula="
                    + crs.getString("IDPELICULA")
                    + "&operacion=comprar'>Comprar Pelicula</a></td>";
            html += "</tr>";

        }
        html += "</table>";

//        
        return html;

    }

    public String comprarPelicula(int idpelicula) throws SQLException {
        this.conectarSQL();
        String consulta = "SELECT * FROM PELICULAS WHERE IDPELICULA = ?";
        this.crs.setCommand(consulta);
        this.crs.setInt(1, idpelicula);
        this.crs.execute();
        this.crs.beforeFirst();
        String html = "<form>";
        while (crs.next()) {

            html += "TITULO: "
                    + crs.getString("TITULO")
                    + "<br/> codigo de cliente"
                    + "<input type='text' name='txtidcliente'/>"
                    + "<br/>"
                    + "Codigo de Producto"
                    + "<input type='text' name='txtcodigoproducto'/>"
                    + "<br/>"
                    + "Unidades"
                    + "<input type='text' name='txtunidades'/>";

        }
        html += "</form>";
        return html;
    }

    public ArrayList<Genero> getGeneros() throws SQLException
    {
        this.conectarSQL();
        String consulta = "SELECT * FROM GENEROS";
        this.crs.setCommand(consulta);
        this.crs.execute(this.cn);
        this.crs.beforeFirst();
        ArrayList<Genero> lista = new ArrayList();
        while (this.crs.next())
        {
            Genero gen = new Genero();
            gen.setIdgenero(this.crs.getInt("IDGENERO"));
            gen.setGenero(this.crs.getString("GENERO"));
            lista.add(gen);
        }
        return lista;
    }    
    
    public ArrayList<Pelicula> getPeliculasGenero(int idgenero) throws SQLException
    {
        this.conectarSQL();
        String consulta = "SELECT * FROM PELICULAS WHERE IDGENERO = ?";
        this.crs.setCommand(consulta);
        this.crs.setInt(1, idgenero);
        this.crs.execute(this.cn);
        this.crs.beforeFirst();
        ArrayList<Pelicula> lista = new ArrayList();
        while (this.crs.next())
        {
            Pelicula peli = new Pelicula();
            peli.setIdpelicula(this.crs.getInt("IDPELICULA"));
            peli.setTitulo(this.crs.getString("TITULO"));
            peli.setPrecio(this.crs.getInt("PRECIO"));
            peli.setFoto(this.crs.getString("FOTO"));
            peli.setActores(this.crs.getString("ACTORES"));
            peli.setArgumento(this.crs.getString("ARGUMENTO"));
            peli.setIdgenero(this.crs.getInt("IDGENERO"));
            lista.add(peli);
        }
        return lista;
    } 
    
    public Pelicula getPelicula(int idpelicula) throws SQLException
    {
        this.conectarSQL();
        String consulta = "SELECT * FROM PELICULAS WHERE IDPELICULA = ?";
        this.crs.setCommand(consulta);
        this.crs.setInt(1, idpelicula);
        this.crs.execute(this.cn);
        this.crs.beforeFirst();
        if (this.crs.next())
        {
            Pelicula peli = new Pelicula();
            peli.setIdpelicula(this.crs.getInt("IDPELICULA"));
            peli.setTitulo(this.crs.getString("TITULO"));
            peli.setPrecio(this.crs.getInt("PRECIO"));
            peli.setFoto(this.crs.getString("FOTO"));
            peli.setActores(this.crs.getString("ACTORES"));
            peli.setArgumento(this.crs.getString("ARGUMENTO"));
            peli.setIdgenero(this.crs.getInt("IDGENERO"));
            return peli;
        }else
        {
            return null;
        }
    }     
    
    public ArrayList<Pelicula> getPeliculasCarrito(ArrayList<Integer> peliculas)
            throws SQLException
    {
        this.conectarSQL();
        String datos = "";
        for (int idpeli: peliculas)
        {
            datos += idpeli + ",";
        }
        datos = datos.substring(0, datos.length() - 1);
        String consulta = "SELECT * FROM PELICULAS WHERE IDPELICULA IN ("
                + datos + ")";
        this.crs.setCommand(consulta);
        this.crs.execute(this.cn);
        this.crs.beforeFirst();
        ArrayList<Pelicula> lista = new ArrayList();
        while (this.crs.next())
        {
            Pelicula peli = new Pelicula();
            peli.setIdpelicula(this.crs.getInt("IDPELICULA"));
            peli.setTitulo(this.crs.getString("TITULO"));
            peli.setPrecio(this.crs.getInt("PRECIO"));
            peli.setFoto(this.crs.getString("FOTO"));
            peli.setActores(this.crs.getString("ACTORES"));
            peli.setArgumento(this.crs.getString("ARGUMENTO"));
            peli.setIdgenero(this.crs.getInt("IDGENERO"));
            lista.add(peli);
        }
        return lista;
    }     

}
