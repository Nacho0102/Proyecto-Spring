/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import objetos.Plantilla;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;

/**
 *
 * @author NachoP
 */
public class JdbcPlantillaDao implements InitializingBean, IPlantillaDao{
    
     private DataSource dataSource;
     private SelectAllPlantilla selectplantilla;
     private UpdateSalarioPlantilla updatesal;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectplantilla = new SelectAllPlantilla(this.dataSource);
        this.updatesal = new UpdateSalarioPlantilla(this.dataSource);
    }

     
    @Override
    public void afterPropertiesSet() throws Exception {
         if (dataSource == null) {
            throw new BeanCreationException("Debe establecer el dataSource");
        }
    }

    @Override
    public List<Plantilla> findAll() {
        return this.selectplantilla.execute();
    }

    @Override
    public void modificarEmpleado(Plantilla plantilla) {
        Map parametros = new HashMap();
        parametros.put("SALARIO",plantilla.getSalario());
        this.updatesal.updateByNamedParam(parametros);
        
        
    }
    
}
