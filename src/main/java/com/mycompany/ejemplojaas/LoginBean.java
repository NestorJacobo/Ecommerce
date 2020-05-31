/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplojaas;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author Dann
 */
@Named(value = "login")
@RequestScoped
public class LoginBean
{

    private String errorMessage;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_ejemploJAAS_war_1.0-SNAPSHOTPU");

    private UserTransaction utx;
    private int errorsCounter;
    private String usuario = "", contrasenia = "";

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean()
    {
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getContrasenia()
    {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia)
    {
        this.contrasenia = contrasenia;
    }

    public String login()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try
        {

            request.login(usuario, contrasenia);
            System.out.println("paso 1");
        } catch (ServletException ex)
        {
            System.out.println(ex.getMessage());
            if (ex.getMessage().contains("Login failed"))
            {
                errorMessage = "login.failed";
            }
            System.out.println("paso 2");
            return "login2.xhtml";
        }
        Principal user = request.getUserPrincipal();
//    setPersons(new UsersJpaController(utx,emf).findUsers(usuario));
//    context.getExternalContext().getSessionMap().put("persons", persons);
        System.out.println("paso 3");

        if (request.isUserInRole("ADMINS")) {
            
            System.out.println("Usuario: " + usuario);
            System.out.println("Contraseña: " + contrasenia);
            System.out.println("Creando la sesión...");
            HttpSession sesion = request.getSession(true);
            
            if (sesion.getAttribute("nombre") != null) {
                System.out.println("La sesión no tenía usuario");
            } else {
                System.out.println("La sesión ya traía un usuario: "+usuario);
                
                sesion.setAttribute("usuario", usuario);
                System.out.println("Se metió usuario "+usuario+" a la sesión");
                sesion.setMaxInactiveInterval(600);
                
                System.out.println("Atributo de la sesión: "+sesion.getAttribute("usuario"));
            }
            return "/secured/admin/index.jsp";

        } else
        {
            return "/secured/user/menu.xhtml";
        }
    }

    public String logout()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try
        {
            externalContext.invalidateSession();
            request.logout();
        } catch (ServletException ex)
        {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            return "error";
        }

        errorMessage = "";
        errorsCounter = 0;
        return "/login.xhtml?faces-redirect=true";
    }

}
