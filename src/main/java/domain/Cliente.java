/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nesto
 */
@XmlRootElement
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
	
    private Long clienteid;

    private String empresa;

    private String nombreContacto;

    private String area;

    private String telefono;

    private String rfc;

    private String email;

    private boolean activo;

    private String paginaWeb;

    private String domicilioFiscal;

    private Collection<Ordenventa> ordenventaCollection;

    public Cliente() {
    }

    public Cliente(Long clienteid) {
        this.clienteid = clienteid;
    }

    public Cliente(Long clienteid, String empresa, String nombreContacto, String area, String telefono, String rfc, String email, boolean activo, String paginaWeb, String domicilioFiscal) {
        this.clienteid = clienteid;
        this.empresa = empresa;
        this.nombreContacto = nombreContacto;
        this.area = area;
        this.telefono = telefono;
        this.rfc = rfc;
        this.email = email;
        this.activo = activo;
        this.paginaWeb = paginaWeb;
        this.domicilioFiscal = domicilioFiscal;
    }

    public Long getClienteid() {
        return clienteid;
    }

    public void setClienteid(Long clienteid) {
        this.clienteid = clienteid;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getDomicilioFiscal() {
        return domicilioFiscal;
    }

    public void setDomicilioFiscal(String domicilioFiscal) {
        this.domicilioFiscal = domicilioFiscal;
    }
	
	@XmlTransient
    @JsonbTransient
    public Collection<Ordenventa> getOrdenventaCollection() {
        return ordenventaCollection;
    }

    public void setOrdenventaCollection(Collection<Ordenventa> ordenventaCollection) {
        this.ordenventaCollection = ordenventaCollection;
    }

}
