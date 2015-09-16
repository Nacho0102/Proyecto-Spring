/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import objetos.Plantilla;

/**
 *
 * @author NachoP
 */
public interface IPlantillaDao {
    
     public List<Plantilla> findAll();
     public void modificarEmpleado(Plantilla plantilla);
    
}
