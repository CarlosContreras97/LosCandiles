/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

/**
 *
 * @author TOSHIBA
 */
import Clases.ConsultaEmpleado;
import Clases.ConsultaEmpleadoComanda;
import Clases.ConsultaProductosDetalleComanda;
import static Conexion.ConexionLosCandiles.consultarProductosDetalleComanda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

public class ConexionLosCandiles {
    private static String serv;
    private static String user;
    private static String pass;

    
    public static boolean login(String serv, String user, String password) {
        setServ(serv);
        setUser(user);
        setPass(password);
        
        Connection con = conectar();
        if(con!=null) {
            cerrarConexion(con);
            return true;
        } else {
            return false;
        }
                
    }
    
    public static Connection conectar() {
        Connection con = null;
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://"+serv+";databaseName=LosCandiles";
            con = (Connection) DriverManager.getConnection(url, user, pass);
            //JOptionPane.showMessageDialog(null,"Conexion exitosa");
            return con;
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null,"Conexion Fallida: "+ex);           
            
        }
         return con;
    }
    
    public static void cerrarConexion(Connection con) {
        try {
            con.close();
        }catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
    
    public static void setServ(String aux) {
        serv = aux;
    }
    
    public static void setUser(String aux) {
        user = aux;
    }
    
    public static void setPass(String aux) {
        pass = aux;
    }
    
    
    public  static Vector<ConsultaEmpleado> consultarDatos(String consulta){
       Connection con = conectar();
        
        Vector<ConsultaEmpleado> empleados = new Vector <ConsultaEmpleado>();
        ConsultaEmpleado emp = null;
        
        if(con == null) conectar();
        
        try{
            Statement smt=con.createStatement(); //Crea un objeto para poder hacer la consultar con ResultSet
            ResultSet r = smt.executeQuery(consulta); //Es el equivalente a la wea que devuelve el metodo listar() :v
            
            //Setear los datos que devuelve la consulta al vector de la clase ConsultaEmpleado
            while(r.next()){
                emp = new ConsultaEmpleado();
                emp.setIDEmpleado(r.getString(1));
                emp.setNombreEmpleado(r.getString(2));
                //Agregar los datos anteriores al vector
                empleados.add(emp);
            }
            smt.close();
            r.close();
        }catch(SQLException ex){ ex.printStackTrace(); }

        return empleados;
        
    }/////
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public  static Vector<ConsultaProductosDetalleComanda> consultarProductosDetalleComanda(String consulta){
       Connection con = conectar();
        
        Vector<ConsultaProductosDetalleComanda> productos = new Vector <ConsultaProductosDetalleComanda>();
        ConsultaProductosDetalleComanda prod = null;
        
        if(con == null) conectar();
        
        try{
            Statement smt=con.createStatement(); //Crea un objeto para poder hacer la consultar con ResultSet
            ResultSet r = smt.executeQuery(consulta); //Es el equivalente a la wea que devuelve el metodo listar() :v
            
            //Setear los datos que devuelve la consulta al vector de la clase ConsultaEmpleado
            while(r.next()){
                prod = new ConsultaProductosDetalleComanda();
                prod.setiDProducto(r.getString(1));
                prod.setNombre(r.getString(2));
                //Agregar los datos anteriores al vector
                productos.add(prod);
            }
            smt.close();
            r.close();
        }catch(SQLException ex){ ex.printStackTrace(); }

        return productos;
        
    }/////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public  static Vector<ConsultaEmpleadoComanda> consultarEmpleadosComanda(String consulta){
       Connection con = conectar();
        
        Vector<ConsultaEmpleadoComanda> productos = new Vector <ConsultaEmpleadoComanda>();
        ConsultaEmpleadoComanda emp = null;
        
        if(con == null) conectar();
        
        try{
            Statement smt=con.createStatement(); //Crea un objeto para poder hacer la consultar con ResultSet
            ResultSet r = smt.executeQuery(consulta); //Es el equivalente a la wea que devuelve el metodo listar() :v
            
            //Setear los datos que devuelve la consulta al vector de la clase ConsultaEmpleado
            while(r.next()){
                emp = new ConsultaEmpleadoComanda();
                emp.setIDEmpleado(r.getString(1));
                emp.setNombreEmpleado(r.getString(2));
                //Agregar los datos anteriores al vector
                productos.add(emp);
            }
            smt.close();
            r.close();
        }catch(SQLException ex){ ex.printStackTrace(); }

        return productos;
        
    }/////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
}

