/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import objetos.Empleado;
import org.springframework.jdbc.object.MappingSqlQuery;

/**
 *
 * @author NachoP
 */
public class SelectAllEmpleados extends MappingSqlQuery<Empleado>{

    static String consulta = "SELECT * FROM EMP";
    
    public SelectAllEmpleados(DataSource ds)
    {
        super(ds,consulta);
    }
    
    @Override
    protected Empleado mapRow(ResultSet rs, int i) throws SQLException {
        Empleado emp = new Empleado();
        emp.setApellido(rs.getString("APELLIDO"));
        emp.setOficio(rs.getString("OFICIO"));
        emp.setSalario(rs.getInt("SALARIO"));
        emp.setDeptno(rs.getInt("DEPT_NO"));
        return emp;
    }
    
}
