/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import objetos.Plantilla;
import org.springframework.jdbc.object.MappingSqlQuery;

/**
 *
 * @author NachoP
 */
public class SelectAllPlantilla extends MappingSqlQuery<Plantilla>{
    
    static String consulta = "SELECT * FROM PLANTILLA";
    
    public SelectAllPlantilla(DataSource ds)
    {
        super(ds,consulta);
    }

    @Override
    protected Plantilla mapRow(ResultSet rs, int i) throws SQLException {
        Plantilla p = new Plantilla();
        p.setApellido(rs.getString("APELLIDO"));
        p.setSalario(rs.getInt("SALARIO"));
        p.setFuncion(rs.getString("FUNCION"));
        return p;
                
    }
    
    
}
