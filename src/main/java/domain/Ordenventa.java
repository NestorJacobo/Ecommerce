/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Nesto
 */

public class Ordenventa implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Long ordenventaid;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date fechaVenta;
    private String status;
    private short iva;
    private long subtotal;
    private long total;
    private String descripcion;
    private Collection<Ventadetalle> ventadetalleCollection;
    private Cliente clienteid;

    public Ordenventa() {
    }

    public Collection<Ventadetalle> getVentadetalleCollection() {
        return ventadetalleCollection;
    }

    public void setVentadetalleCollection(Collection<Ventadetalle> ventadetalleCollection) {
        this.ventadetalleCollection = ventadetalleCollection;
    }

    public Cliente getClienteid() {
        return clienteid;
    }

    public void setClienteid(Cliente clienteid) {
        this.clienteid = clienteid;
    }

    
    
    public Ordenventa(Long ordenventaid) {
        this.ordenventaid = ordenventaid;
    }

    public Long getOrdenventaid() {
        return ordenventaid;
    }

    public void setOrdenventaid(Long ordenventaid) {
        this.ordenventaid = ordenventaid;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public short getIva() {
        return iva;
    }

    public void setIva(short iva) {
        this.iva = iva;
    }

    public long getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(long subtotal) {
        this.subtotal = subtotal;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Ordenventa{" + "ordenventaid=" + ordenventaid + ", fechaVenta=" + fechaVenta + ", status=" + status + ", iva=" + iva + ", subtotal=" + subtotal + ", total=" + total + ", descripcion=" + descripcion + '}';
    }
    
    
}
