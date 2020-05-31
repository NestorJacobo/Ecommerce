/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import cad.InsercionDatos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fgb
 */
@WebServlet(name = "RegistroCliente", urlPatterns = {"/RegistroCliente"})
public class RegistroCliente extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String name=request.getParameter("nombre");
        String email=request.getParameter("usuario");
        //String rfc=request.getParameter("rfc");
        //String estado=request.getParameter("estado");
        //String municipio=request.getParameter("municipio");
        //String calle=request.getParameter("calle");
        //String numero=request.getParameter("numero");
        //String cp=request.getParameter("cp");
        //String correo=request.getParameter("correo");
        String password=request.getParameter("password");
        String campos="email,password,name";
        String camposRol ="email";
        String valores="'"+email+"','"+password+"','"+name+"'";
        String valoresRol="'"+ email +"'";
        System.out.println("los valores son:"+valores);
        System.out.println("los valores son:"+valoresRol);
        InsercionDatos in=new InsercionDatos();
        in.insertar(campos,"users", valores);
        in.insertar(camposRol,"user_groups", valoresRol);
        response.sendRedirect("index.jsp");
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
        } catch (SQLException ex) {
            Logger.getLogger(RegistroCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistroCliente.class.getName()).log(Level.SEVERE, null, ex);
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
