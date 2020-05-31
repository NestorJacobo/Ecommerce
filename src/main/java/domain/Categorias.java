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
@XmlRootElement(name ="tblCategoria")
public class Categorias {
    
    private int codigo;
    private String nombre;
    private int visible; 
    private int categoria_superior; 

    public Categorias() {
    }

    public Categorias(int codigo) {
        this.codigo = codigo;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public int getCategoria_superior() {
        return categoria_superior;
    }

    public void setCategoria_superior(int categoria_superior) {
        this.categoria_superior = categoria_superior;
    }

    @Override
    public String toString() {
        return "Categorias{" + "codigo=" + codigo + ", nombre=" + nombre + ", visible=" + visible + ", categoria_superior=" + categoria_superior + '}';
    }
    
    
    
}
