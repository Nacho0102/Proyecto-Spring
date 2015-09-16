/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.sql.DataSource;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

/**
 *
 * @author NachoP
 */
public class UpdateDepartamento extends SqlUpdate{
    
    static String consulta = 
            "UPDATE DEPT SET DNOMBRE = :NOMBRE"
            + ", LOC = :LOCALIDAD"
            + " WHERE DEPT_NO = :NUMERO";
    
    public UpdateDepartamento (DataSource datasource)
    {
        super(datasource, consulta);
        super.declareParameter(new SqlParameter("NOMBRE", java.sql.Types.VARCHAR));
        super.declareParameter(new SqlParameter("LOCALIDAD", java.sql.Types.VARCHAR));
        super.declareParameter(new SqlParameter("NUMERO", java.sql.Types.INTEGER));
        
    }
    
}
