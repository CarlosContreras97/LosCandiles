/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


public class ConsultaProductosDetalleComanda {
    private String iDProducto;
    private String nombre;
    
    public ConsultaProductosDetalleComanda(){}

    public ConsultaProductosDetalleComanda(String iDProducto, String nombre) {
        this.iDProducto = iDProducto;
        this.nombre = nombre;
    }

    public String getiDProducto() {
        return iDProducto;
    }

    public void setiDProducto(String iDProducto) {
        this.iDProducto = iDProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
