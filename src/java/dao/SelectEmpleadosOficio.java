package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import objetos.Empleado;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

public class SelectEmpleadosOficio extends MappingSqlQuery<Empleado>
{
    static String consulta = 
            "SELECT * FROM EMP WHERE UPPER(OFICIO) = UPPER(:OFICIO)";
    
    public SelectEmpleadosOficio(DataSource ds)
    {
        super(ds, consulta);
        super.declareParameter(new SqlParameter("OFICIO", java.sql.Types.VARCHAR));
    }

    @Override
    protected Empleado mapRow(ResultSet rs, int i) throws SQLException {
        Empleado emp = new Empleado();
        emp.setEmpno(rs.getInt("EMP_NO"));
        emp.setApellido(rs.getString("APELLIDO"));
        emp.setOficio(rs.getString("OFICIO"));
        emp.setSalario(rs.getInt("SALARIO"));
        emp.setDeptno(rs.getInt("DEPT_NO"));
        return emp;
    }
    
}
