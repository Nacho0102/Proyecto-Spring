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
import org.springframework.jdbc.object.MappingSqlQuery;

/**
 *
 * @author NachoP
 */
public class SelectAllDepartamentos extends MappingSqlQuery<Departamento> {

    
    //static para que 1º cree la consulta y luego el constructor
    static String consulta = "SELECT * FROM DEPT";
    
    public SelectAllDepartamentos(DataSource datasource)
    {
        super(datasource,consulta);
    
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
