/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import objetos.Cliente;

/**
 *
 * @author NachoP
 */
public interface IClientesDaoSupport {
    
    void insertarCliente (int idcliente, String nombre, String direccion);
    List<Cliente> getClientes();
    
}
