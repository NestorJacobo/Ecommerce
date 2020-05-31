/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nesto
 */
@XmlRootElement(name ="tblVentas")
public class Ventas {
    
    private int idVenta;
    private int idProducto;
    private int cantidad;
    private double precioUnitario;
    private double precioTotal;
    private String usuarioventa;

    public Ventas() {
    }

    public Ventas(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getUsuarioventa() {
        return usuarioventa;
    }

    public void setUsuarioventa(String usuarioventa) {
        this.usuarioventa = usuarioventa;
    }

    @Override
    public String toString() {
        return "Ventas{" + "idVenta=" + idVenta + ", idProducto=" + idProducto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", precioTotal=" + precioTotal + ", usuarioventa=" + usuarioventa + '}';
    }
    
    
    
    
}
