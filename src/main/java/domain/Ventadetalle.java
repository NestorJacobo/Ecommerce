/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Nesto
 */

public class Ventadetalle implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int cantidad;
    private int precioUnitario;
    private long importe;
    private Producto producto;
    private Ordenventa ordenventa;

    public Ventadetalle() {
    }
    
    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public long getImporte() {
        return importe;
    }

    public void setImporte(long importe) {
        this.importe = importe;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Ordenventa getOrdenventa() {
        return ordenventa;
    }

    public void setOrdenventa(Ordenventa ordenventa) {
        this.ordenventa = ordenventa;
    }

    @Override
    public String toString() {
        return "Ventadetalle{" + "cantidad=" + cantidad + ", precio_unitario=" + precioUnitario + ", importe=" + importe + ", producto=" + producto + ", ordenventa=" + ordenventa + '}';
    }
    
}
