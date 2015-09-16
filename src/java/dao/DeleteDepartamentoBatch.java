/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.sql.DataSource;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

/**
 *
 * @author NachoP
 */
public class DeleteDepartamentoBatch extends BatchSqlUpdate{
    
    static String consulta= 
            "DELETE FROM DEPT WHERE DEPT_NO = :NUMERO";
    static int maximo = 4;
    
    public DeleteDepartamentoBatch(DataSource ds)
    {
        super(ds,consulta);
        super.declareParameter(new SqlParameter("NUMERO",java.sql.Types.INTEGER));
        super.setBatchSize(maximo);
    }
    
}
