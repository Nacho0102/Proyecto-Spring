/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import objetos.Empleado;

/**
 *
 * @author NachoP
 */
public interface EmpleadoDao {

    public List<Empleado> findAll();

    public List<Empleado> findByOficio(String oficio);

    public String findById(int idempleado);

    public void insertarEmpleado(Empleado empleado);

    public void modificarEmpleado(Empleado empleado);

    public void eliminarEmpleado(int idempleado);

}
