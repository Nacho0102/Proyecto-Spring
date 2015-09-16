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
import objetos.Departamento;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author NachoP
 */
//Clase JDBC Template (la clase principal)
public class JdbcDepartamentoDao implements InitializingBean, DepartamentoDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SelectAllDepartamentos selectdept;
    //crear un objeto parametrizdo
    private SelectParametrizado selectparam;
    private UpdateDepartamento updatedept;
    private InsertDepartamento insertdept;
    private DeleteDepartamentoBatch delete;
    

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
        this.selectdept = new SelectAllDepartamentos(this.dataSource);
//       Map mapa --> "VARIBLE",VALOR
//        this.selectdept.executeByNamedParam(mapa)
        this.selectparam = new SelectParametrizado(this.dataSource);
        this.updatedept = new UpdateDepartamento(this.dataSource);
        this.insertdept = new InsertDepartamento(this.dataSource);
        this.delete = new DeleteDepartamentoBatch(this.dataSource);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("Debe establecer el dataSource");
        }
    }

    @Override
    public List<Departamento> findAll() {

        return this.selectdept.execute();

    }

    @Override
    public List<Departamento> findByLocalidad(String localidad) {

        //Declarar un mapa con todos los parametros
        Map parametros = new HashMap();
        //Almacenar en el mapa todos los nombre de parametro con su valor correspondiente
        parametros.put("LOCALIDAD", localidad);
        return this.selectparam.executeByNamedParam(parametros);

    }

    @Override
    public String findById(int iddepartamento) {

        //queryForObject-->solo devuelve un objeto y debe ser una clase wrapper (primitivo)
        String nombre = jdbcTemplate.queryForObject(
                "SELECT DNOMBRE from DEPT WHERE DEPT_NO = ?",
                new Object[]{iddepartamento}, String.class);
        return nombre;

    }

    @Override
    public void insertarDepartamento(Departamento departamento) {

        Map<String, Object> paramMap = new HashMap();
        paramMap.put("NUMERO", departamento.getNumero());
        paramMap.put("NOMBRE", departamento.getNombre());
        paramMap.put("LOCALIDAD", departamento.getLocalidad());
        
        this.insertdept.updateByNamedParam(paramMap);
    }

    @Override
    public void modificarDepartamento(Departamento departamento) {

        Map parametros = new HashMap();
        parametros.put("NOMBRE", departamento.getNombre());
        parametros.put("LOCALIDAD", departamento.getLocalidad());
        parametros.put("NUMERO", departamento.getNumero());
        this.updatedept.updateByNamedParam(parametros);

    }

    @Override
    public void eliminarDepartamento(int iddepartamento) {
    
        Map parametros = new HashMap();
        parametros.put("NUMERO",iddepartamento);
        this.delete.updateByNamedParam(parametros);
        //libera la memoria y realiza la accion
        this.delete.flush();
        
    }

}
