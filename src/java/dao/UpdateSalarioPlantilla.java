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
public class UpdateSalarioPlantilla extends SqlUpdate{
    
    static String consulta = 
            "UPDATE PLANTILLA SET SALARIO = SALARIO + :SALARIO"
            + "WHERE EMP_NO = :EMPNO";
            
    
    public UpdateSalarioPlantilla (DataSource datasource)
    {
        super(datasource, consulta);
       
        super.declareParameter(new SqlParameter("SALARIO", java.sql.Types.INTEGER));
        super.declareParameter(new SqlParameter("EMP_NO", java.sql.Types.INTEGER));
        
    }
    
    
}
