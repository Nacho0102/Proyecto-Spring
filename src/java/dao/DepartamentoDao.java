/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import objetos.Departamento;

/**
 *
 * @author NachoP
 */
public interface DepartamentoDao {
    
    public List<Departamento> findAll();
    
    public List<Departamento> findByLocalidad(String localidad);
    
    public String findById(int iddepartamento);

    public void insertarDepartamento(Departamento departamento);

    public void modificarDepartamento(Departamento departamento);

    public void eliminarDepartamento(int iddepartamento);

    
}
