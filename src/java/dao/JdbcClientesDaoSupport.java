/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import objetos.Cliente;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 *
 * @author NachoP
 */
public class JdbcClientesDaoSupport extends JdbcDaoSupport implements IClientesDaoSupport{

    @Override
    public void insertarCliente(int idcliente, String nombre, String direccion) {
        String consulta = "INSERT INTO CLIENTES (IDCLIENTE,NOMBRE,DIRECCION) VALUES (?,?,?)";
        
        //siempre un array de Object
        Object param = new Object[]{idcliente,nombre,direccion};
        getJdbcTemplate().update(consulta,param);
    }

    @Override
    public List<Cliente> getClientes() {

        String consulta = "SELECT * FROM CLIENTES";
        MapaClientes mapa = new MapaClientes();
        List<Cliente> clientes = getJdbcTemplate().query(consulta,mapa);
 
//        .query(sql,RowMapper); ---> sin parametros
//        .query(sql, new Object[], RowMapper) --> con parametros
        
        return clientes;
        
    }
    
    
    
    
}
