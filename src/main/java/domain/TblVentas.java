/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nesto
 */
@Entity
@Table(name = "tbl_ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblVentas.findAll", query = "SELECT t FROM TblVentas t"),
    @NamedQuery(name = "TblVentas.findByIdVenta", query = "SELECT t FROM TblVentas t WHERE t.idVenta = :idVenta"),
    @NamedQuery(name = "TblVentas.findByCantidad", query = "SELECT t FROM TblVentas t WHERE t.cantidad = :cantidad"),
    @NamedQuery(name = "TblVentas.findByPrecioUnitario", query = "SELECT t FROM TblVentas t WHERE t.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "TblVentas.findByPrecioTotal", query = "SELECT t FROM TblVentas t WHERE t.precioTotal = :precioTotal"),
    @NamedQuery(name = "TblVentas.findByIdProducto", query = "SELECT t FROM TblVentas t WHERE t.idProducto = :idProducto"),
    @NamedQuery(name = "TblVentas.findByUsuarioventa", query = "SELECT t FROM TblVentas t WHERE t.usuarioventa = :usuarioventa")})
public class TblVentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_venta")
    private Integer idVenta;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_unitario")
    private Double precioUnitario;
    @Column(name = "precio_total")
    private Double precioTotal;
    @Column(name = "id_producto")
    private Integer idProducto;
    @Size(max = 100)
    @Column(name = "usuarioventa")
    private String usuarioventa;

    public TblVentas() {
    }

    public TblVentas(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getUsuarioventa() {
        return usuarioventa;
    }

    public void setUsuarioventa(String usuarioventa) {
        this.usuarioventa = usuarioventa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblVentas)) {
            return false;
        }
        TblVentas other = (TblVentas) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.TblVentas[ idVenta=" + idVenta + " ]";
    }
    
}
