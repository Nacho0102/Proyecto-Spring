/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import objetos.Cliente;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author NachoP
 */
public class MapaClientes implements RowMapper<Cliente> {

    @Override
    public Cliente mapRow(ResultSet rs, int i) throws SQLException {

        Cliente c = new Cliente();
        c.setIdcliente(rs.getInt("IDCLIENTE"));
        c.setNombre(rs.getString("NOMBRE"));
        c.setDireccion(rs.getString("DIRECCION"));
        c.setFoto(rs.getString("IMAGEN_CLIENTE"));
        return c;
        
    }

    
    
}
