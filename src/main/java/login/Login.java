/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import cad.InsercionDatos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fgb
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        System.out.println("usuario: " + usuario);
        System.out.println("passwd: " + password);
        InsercionDatos in = new InsercionDatos();
        ArrayList lista = in.consulta("usuario,password,nombre", "cliente", "usuario='" + usuario + "' and password='" + password + "'", 3);
        if (!lista.isEmpty()) {
            System.out.println("nombre:" + lista.get(2));
            System.out.println("entre a la validadción");
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("usuario", lista.get(0));
            sesion.setAttribute("password", lista.get(1));
            sesion.setAttribute("nombre", lista.get(2));
            System.out.println("Sesión: " + sesion);
            String cadena = "";
            sesion.getAttribute("usuario");
            cadena = sesion.getAttribute("nombre").toString();
            response.sendRedirect("index.jsp");
        } else {
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                response.setContentType("text/html");
                out.println("<script type=\"text/javascript\">");
                out.println("alert('DATOS INCORRECTOS. Intente de nuevo')");
                out.println("window.location='login.xhtml'");
                out.println("</script>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
