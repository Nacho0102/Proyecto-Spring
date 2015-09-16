/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import objetos.Departamento;
import objetos.Doctor;
import objetos.Empleado;
import objetos.Enfermo;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author NachoP
 */
public class ModeloHospital {

    //recupera el origen de datos con el metodo getbean
    //Descomentamos de applicationContext el id="dataSource"
//    e inicializamos el driver:
//    <bean id="dataSource"
//        class="org.springframework.jdbc.datasource.DriverManagerDataSource"
//        p:driverClassName="oracle.jdbc.OracleDriver"
//        p:url="jdbc:oracle:thin:@LOCALHOST:1521:XE"
//        p:username="SYSTEM"
//        p:password="java" />
    private ServletContext servlet;
    private Connection cn;
    private CachedRowSet rs;
    //Copia lo que hay en la BBDD y trabajamos sobre ella 

    public ModeloHospital(ServletContext src) {
        this.servlet = src;
    }

    private Object getBean(String nombreBean) {
        ApplicationContext contexto = WebApplicationContextUtils.getRequiredWebApplicationContext(this.servlet);
        Object bean = contexto.getBean(nombreBean);
        return bean;
    }

    private void conectarOracle() throws SQLException {
        //registrar el driver e inicializar cachedconnection(nuestra BBDD no lo permite Oracle EXPRESS)  o resultset(nos lo permite la BBDD)
        DriverManagerDataSource drv = (DriverManagerDataSource) this.getBean("dataSource");
        this.cn = drv.getConnection();
        this.rs = RowSetProvider.newFactory().createCachedRowSet();

    }

    public ArrayList<String> getApellidoEmpleados() throws SQLException {
        this.conectarOracle();
        Statement st = this.cn.createStatement();
        String consulta = "SELECT APELLIDO FROM EMP";
        ResultSet rs = st.executeQuery(consulta);
        ArrayList<String> lista = new ArrayList();
        while (rs.next()) {
            lista.add(rs.getString("APELLIDO"));
        }
        return lista;
    }

    public ArrayList<Enfermo> getEnfermos() throws SQLException {
        this.conectarOracle();
        String consulta = "SELECT * FROM ENFERMO";
        this.rs.setCommand(consulta);
        this.rs.execute(this.cn);
        this.rs.beforeFirst();
        ArrayList<Enfermo> lista = new ArrayList();
        while (this.rs.next()) {
            Enfermo enf = new Enfermo();
            enf.setInscripcion(this.rs.getString("INSCRIPCION"));
            enf.setApellido(this.rs.getString("APELLIDO"));
            enf.setDireccion(this.rs.getString("DIRECCION"));
            enf.setFechaNacimiento(this.rs.getString("FECHA_NAC"));
            lista.add(enf);
        }
        return lista;
    }

    public void eliminarEnfermo(int inscripcion) throws SQLException {
        this.conectarOracle();
        String consulta = "DELETE FROM ENFERMO WHERE INSCRIPCION=?";
        PreparedStatement pst = this.cn.prepareStatement(consulta);
        pst.setInt(1, inscripcion);
        pst.execute();
    }

    public ArrayList<Departamento> getDepartamentos() throws SQLException {
        this.conectarOracle();
        String consulta = "SELECT * FROM DEPT";
        this.rs.setCommand(consulta);
        this.rs.execute(this.cn);
        this.rs.beforeFirst();
        ArrayList<Departamento> lista = new ArrayList();
        while (this.rs.next()) {
            Departamento d = new Departamento();
            d.setDeptno(this.rs.getInt("DEPT_NO"));
            d.setDnombre(this.rs.getString("DNOMBRE"));
            d.setLoc(this.rs.getString("LOC"));

            lista.add(d);
        }
        return lista;
    }
    
    public void eliminarDepartamento(int deptno) throws SQLException {
        this.conectarOracle();
        String consulta = "DELETE FROM DEPT WHERE DEPT_NO=?";
        PreparedStatement pst = this.cn.prepareStatement(consulta);
        pst.setInt(1, deptno);
        pst.execute();
    }
    
    public void modificarDepartamentos(int deptno, String dnombre, String loc) throws SQLException {
        this.conectarOracle();
        String consulta = "UPDATE DEPT SET DEPT_NO=? "
                + ",DNOMBRE=?,LOC=? WHERE DEPT_NO=?";
        PreparedStatement pst = this.cn.prepareStatement(consulta);
        pst.setInt(1, deptno);
        pst.setString(2, dnombre);
        pst.setString(3, loc);
        pst.setInt(4, deptno);

        pst.executeUpdate();
    }
    
     public void insertarDepartamento(int deptno, String dnombre, String loc) throws SQLException {
        this.conectarOracle();
        String consulta = "INSERT INTO DEPT VALUES (?,?,?)";
        PreparedStatement pst = this.cn.prepareStatement(consulta);
        pst.setInt(1, deptno);
        pst.setString(2, dnombre);
        pst.setString(3, loc);
        pst.execute();
    }
     
     
      public ArrayList<Empleado> getEmpleados() throws SQLException
    {
        this.conectarOracle();
        String consulta = "SELECT * FROM EMP";
        this.rs.setCommand(consulta);
        this.rs.execute(this.cn);
        this.rs.beforeFirst();
        ArrayList<Empleado> lista = new ArrayList();
        while (this.rs.next())
        {
            Empleado emp = new Empleado();
            emp.setEmpno(this.rs.getInt("EMP_NO"));
            emp.setApellido(this.rs.getString("APELLIDO"));
            emp.setOficio(this.rs.getString("OFICIO"));
            emp.setSalario(this.rs.getInt("SALARIO"));
            lista.add(emp);
        }
        return lista;
    }
    
    public ArrayList<Empleado> getEmpleados(ArrayList<Integer> empleados) throws SQLException
    {
        this.conectarOracle();
        String datos = "";
        for (int num: empleados)
        {
            datos += num + ",";
        }
        datos = datos.substring(0, datos.length() - 1);
        String consulta = "SELECT * FROM EMP WHERE EMP_NO IN (" + datos + ")";
        this.rs.setCommand(consulta);
        this.rs.execute(this.cn);
        this.rs.beforeFirst();
        ArrayList<Empleado> lista = new ArrayList();
        while (this.rs.next())
        {
            Empleado emp = new Empleado();
            emp.setEmpno(this.rs.getInt("EMP_NO"));
            emp.setApellido(this.rs.getString("APELLIDO"));
            emp.setOficio(this.rs.getString("OFICIO"));
            emp.setSalario(this.rs.getInt("SALARIO"));
            lista.add(emp);
        }
        return lista;
    }
   
    public Doctor buscarDoctor(String apellido, int doctorno) throws SQLException
    {
        this.conectarOracle();
        String consulta = 
                "SELECT * FROM DOCTOR WHERE UPPER(APELLIDO)=UPPER(?) "
                + " AND DOCTOR_NO = ?";
        this.rs.setCommand(consulta);
        this.rs.setString(1, apellido);
        this.rs.setInt(2, doctorno);
        this.rs.execute(this.cn);
        this.rs.beforeFirst();
        if (this.rs.next())
        {
            Doctor doc = new Doctor();
            doc.setDoctorno(this.rs.getInt("DOCTOR_NO"));
            doc.setApellido(this.rs.getString("APELLIDO"));
            doc.setHospitalcod(this.rs.getInt("HOSPITAL_COD"));
            doc.setEspecialidad(this.rs.getString("ESPECIALIDAD"));
            doc.setSalario(this.rs.getInt("SALARIO"));
            return doc;
        }else{
            return null;
        }
  
    }
    
    public void modificarDoctor(Doctor doc) throws SQLException
    {
        this.conectarOracle();
        String consulta = 
                "UPDATE DOCTOR SET APELLIDO = ?, HOSPITAL_COD = ?"
                + ", ESPECIALIDAD = ?, SALARIO = ?"
                + " WHERE DOCTOR_NO = ?";
        
        //consultas de accion
        PreparedStatement pst = this.cn.prepareStatement(consulta);
        pst.setString(1, doc.getApellido());
        pst.setInt(2, doc.getHospitalcod());
        pst.setString(3, doc.getEspecialidad());
        pst.setInt(4, doc.getSalario());
        pst.setInt(5, doc.getDoctorno());
        pst.execute();
    }
    
     
}
