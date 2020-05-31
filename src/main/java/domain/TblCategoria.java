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
@Table(name = "tbl_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCategoria.findAll", query = "SELECT t FROM TblCategoria t"),
    @NamedQuery(name = "TblCategoria.findByCodigo", query = "SELECT t FROM TblCategoria t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "TblCategoria.findByNombre", query = "SELECT t FROM TblCategoria t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblCategoria.findByVisible", query = "SELECT t FROM TblCategoria t WHERE t.visible = :visible"),
    @NamedQuery(name = "TblCategoria.findByCategoriaSuperior", query = "SELECT t FROM TblCategoria t WHERE t.categoriaSuperior = :categoriaSuperior")})
public class TblCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "visible")
    private Short visible;
    @Column(name = "categoria_superior")
    private BigInteger categoriaSuperior;

    public TblCategoria() {
    }

    public TblCategoria(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getVisible() {
        return visible;
    }

    public void setVisible(Short visible) {
        this.visible = visible;
    }

    public BigInteger getCategoriaSuperior() {
        return categoriaSuperior;
    }

    public void setCategoriaSuperior(BigInteger categoriaSuperior) {
        this.categoriaSuperior = categoriaSuperior;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCategoria)) {
            return false;
        }
        TblCategoria other = (TblCategoria) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.TblCategoria[ codigo=" + codigo + " ]";
    }
    
}
