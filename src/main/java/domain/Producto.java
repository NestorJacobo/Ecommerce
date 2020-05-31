/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Categoria;
import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nesto
 */

public class Producto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int productoid;
    private String nombre;
    private int precioUnitario;
    private double precionuevo;
    private int codigoMarca;
    private Categoria categoriaid;
    private String unidadMedida;
    private String img;
    private String descripcion;

    public Producto() {
    }

    public Producto(int productoid) {
        this.productoid = productoid;
    }
    
    

    public int getProductoid() {
        return productoid;
    }

    public void setProductoid(int productoid) {
        this.productoid = productoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    

    @JsonbTransient
    public double getPrecionuevo() {
        return precionuevo;
    }

    public void setPrecionuevo(double precionuevo) {
        this.precionuevo = precionuevo;
    }

    @JsonbTransient
    public int getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoMarca(int codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public Categoria getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(Categoria categoriaid) {
        this.categoriaid = categoriaid;
    }

    

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    @JsonbTransient
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Producto{" + "productoid=" + productoid + ", nombre=" + nombre + ", precioUnitario=" + precioUnitario + ", precionuevo=" + precionuevo + ", codigoMarca=" + codigoMarca + ", categoriaid=" + categoriaid + ", unidadMedida=" + unidadMedida + ", img=" + img + ", descripcion=" + descripcion + '}';
    }

    

    
}
