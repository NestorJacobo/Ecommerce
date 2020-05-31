/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "tbl_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProducto.findAll", query = "SELECT t FROM TblProducto t"),
    @NamedQuery(name = "TblProducto.findByWebid", query = "SELECT t FROM TblProducto t WHERE t.webid = :webid"),
    @NamedQuery(name = "TblProducto.findByNombre", query = "SELECT t FROM TblProducto t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblProducto.findByPrecio", query = "SELECT t FROM TblProducto t WHERE t.precio = :precio"),
    @NamedQuery(name = "TblProducto.findByPrecionuevo", query = "SELECT t FROM TblProducto t WHERE t.precionuevo = :precionuevo"),
    @NamedQuery(name = "TblProducto.findByStock", query = "SELECT t FROM TblProducto t WHERE t.stock = :stock"),
    @NamedQuery(name = "TblProducto.findByNuevo", query = "SELECT t FROM TblProducto t WHERE t.nuevo = :nuevo"),
    @NamedQuery(name = "TblProducto.findByRecomendado", query = "SELECT t FROM TblProducto t WHERE t.recomendado = :recomendado"),
    @NamedQuery(name = "TblProducto.findByDescripcion", query = "SELECT t FROM TblProducto t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TblProducto.findByVisible", query = "SELECT t FROM TblProducto t WHERE t.visible = :visible"),
    @NamedQuery(name = "TblProducto.findByImg", query = "SELECT t FROM TblProducto t WHERE t.img = :img"),
    @NamedQuery(name = "TblProducto.findByUnidadMedida", query = "SELECT t FROM TblProducto t WHERE t.unidadMedida = :unidadMedida"),
    @NamedQuery(name = "TblProducto.findByCodigoCategoria", query = "SELECT t FROM TblProducto t WHERE t.codigoCategoria = :codigoCategoria"),
    @NamedQuery(name = "TblProducto.findByCodigoMarca", query = "SELECT t FROM TblProducto t WHERE t.codigoMarca = :codigoMarca")})
public class TblProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "webid")
    private Integer webid;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precio")
    private BigInteger precio;
    @Column(name = "precionuevo")
    private BigInteger precionuevo;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "nuevo")
    private Short nuevo;
    @Column(name = "recomendado")
    private Short recomendado;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "visible")
    private Short visible;
    @Size(max = 100)
    @Column(name = "img")
    private String img;
    @Size(max = 2147483647)
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Column(name = "codigo_categoria")
    private Integer codigoCategoria;
    @Column(name = "codigo_marca")
    private Integer codigoMarca;

    public TblProducto() {
    }

    public TblProducto(Integer webid) {
        this.webid = webid;
    }

    public Integer getWebid() {
        return webid;
    }

    public void setWebid(Integer webid) {
        this.webid = webid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
    }

    public BigInteger getPrecionuevo() {
        return precionuevo;
    }

    public void setPrecionuevo(BigInteger precionuevo) {
        this.precionuevo = precionuevo;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Short getNuevo() {
        return nuevo;
    }

    public void setNuevo(Short nuevo) {
        this.nuevo = nuevo;
    }

    public Short getRecomendado() {
        return recomendado;
    }

    public void setRecomendado(Short recomendado) {
        this.recomendado = recomendado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getVisible() {
        return visible;
    }

    public void setVisible(Short visible) {
        this.visible = visible;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Integer getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoMarca(Integer codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webid != null ? webid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProducto)) {
            return false;
        }
        TblProducto other = (TblProducto) object;
        if ((this.webid == null && other.webid != null) || (this.webid != null && !this.webid.equals(other.webid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.TblProducto[ webid=" + webid + " ]";
    }
    
}
