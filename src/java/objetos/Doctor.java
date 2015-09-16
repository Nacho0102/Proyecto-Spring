/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author NachoP
 */
public class Doctor {
    
    private int doctorno;
    private String apellido;
    private int hospitalcod;
    private String especialidad;
    private int salario;

    public int getDoctorno() {
        return doctorno;
    }

    public void setDoctorno(int doctorno) {
        this.doctorno = doctorno;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getHospitalcod() {
        return hospitalcod;
    }

    public void setHospitalcod(int hospitalcod) {
        this.hospitalcod = hospitalcod;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    
    
    
}
