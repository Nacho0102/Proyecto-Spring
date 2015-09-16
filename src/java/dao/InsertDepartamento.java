/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Types;
import javax.sql.DataSource;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

/**
 *
 * @author NachoP
 */
public class InsertDepartamento extends SqlUpdate {
    
    static final String consulta = "INSERT INTO DEPT VALUES(:NUMERO, :NOMBRE, :LOCALIDAD)";
    
    public InsertDepartamento(DataSource dataSource)
    {
        super(dataSource,consulta);
        super.declareParameter(new SqlParameter("NUMERO", Types.INTEGER));
        super.declareParameter(new SqlParameter("NOMBRE", Types.VARCHAR));
        super.declareParameter(new SqlParameter("LOCALIDAD", Types.VARCHAR));


        
    }
    
}
