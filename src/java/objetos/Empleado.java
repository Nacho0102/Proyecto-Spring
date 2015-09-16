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
public class Empleado {
    
    private int deptno;
    private String apellido;
    private int salario;
    private String oficio;
    private int empno;
    private int sumaEmpleados;

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public int getEmpno() {
        return empno;
    }

    public int getSumaEmpleados() {
        return sumaEmpleados;
    }

    public void setSumaEmpleados(int sumaEmpleados) {
        this.sumaEmpleados = sumaEmpleados;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    
    
}
