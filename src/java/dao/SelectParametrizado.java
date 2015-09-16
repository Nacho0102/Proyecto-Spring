/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import objetos.Departamento;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

/**
 *
 * @author NachoP
 */
public class SelectParametrizado extends MappingSqlQuery<Departamento>{

//    (: LOCALIDAD) PARA QUE NO LO CONFUNDA CON EL NOMBRE DE CAMPO
    static String consulta =
            "SELECT * FROM DEPT WHERE UPPER(LOC) = UPPER(:LOCALIDAD)";
    
    
    //CONSTRUCTOR
    public SelectParametrizado(DataSource datasource)
    {
        super(datasource, consulta);
        super.declareParameter(new SqlParameter("LOCALIDAD", java.sql.Types.VARCHAR));
        
    }
    
    @Override
    protected Departamento mapRow(ResultSet rs, int i) throws SQLException {
        Departamento dept = new Departamento();
        dept.setNumero(rs.getInt("DEPT_NO"));
        dept.setNombre(rs.getString("DNOMBRE"));
        dept.setLocalidad(rs.getString("LOC"));
        return dept;
    }
    
}
