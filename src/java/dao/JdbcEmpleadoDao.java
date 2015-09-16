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
import objetos.Empleado;
import org.springframework.beans.factory.BeanCreationException;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author NachoP
 */
public class JdbcEmpleadoDao implements InitializingBean, EmpleadoDao {

    private DataSource dataSource;
    private SelectAllEmpleados selectemp;
    private SelectEmpleadosOficio selectoficios;

    
    //metodo setter
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectoficios = new SelectEmpleadosOficio(this.dataSource);
        this.selectemp = new SelectAllEmpleados(this.dataSource);
    }

  
    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("Debe establecer el dataSource");
        }
    }

    @Override
    public List<Empleado> findAll() {

        return this.selectemp.execute();
    }

    @Override
    public List<Empleado> findByOficio(String oficio) {
       
        Map parametros = new HashMap();
        //Almacenar en el mapa todos los nombre de parametro con su valor correspondiente
        parametros.put("OFICIO", oficio);
        return this.selectoficios.executeByNamedParam(parametros);
    }

    @Override
    public String findById(int idempleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarEmpleado(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarEmpleado(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarEmpleado(int idempleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
