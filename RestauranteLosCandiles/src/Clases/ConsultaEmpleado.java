/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


public class ConsultaEmpleado {
    private String IDEmpleado;
    private String NombreEmpleado;
    
    public ConsultaEmpleado(){}
    
    public ConsultaEmpleado(String IDEmpleado, String NombreEmpleado) {
        this.IDEmpleado = IDEmpleado;
        this.NombreEmpleado = NombreEmpleado;
    }

    public String getIDEmpleado() {
        return IDEmpleado;
    }

    public void setIDEmpleado(String IDEmpleado) {
        this.IDEmpleado = IDEmpleado;
    }

    public String getNombreEmpleado() {
        return NombreEmpleado;
    }

    public void setNombreEmpleado(String NombreEmpleado) {
        this.NombreEmpleado = NombreEmpleado;
    }

    @Override
    public String toString() {
        return this.NombreEmpleado; //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}
