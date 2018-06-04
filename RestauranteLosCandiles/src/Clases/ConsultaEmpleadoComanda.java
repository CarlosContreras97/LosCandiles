/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author StalinMacias
 */
public class ConsultaEmpleadoComanda {
    private String IDEmpleado;
    private String nombreEmpleado;
    
    public ConsultaEmpleadoComanda(){}

    public ConsultaEmpleadoComanda(String IDEmpleado, String nombreEmpleado) {
        this.IDEmpleado = IDEmpleado;
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getIDEmpleado() {
        return IDEmpleado;
    }

    public void setIDEmpleado(String IDEmpleado) {
        this.IDEmpleado = IDEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    @Override
    public String toString() {
        return this.nombreEmpleado; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
