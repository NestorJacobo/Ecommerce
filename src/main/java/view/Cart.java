/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import JavaBeans.Item;
import JavaBeans.Producto;
import cad.ProductoCad;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import conexion.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import login.Login;
import domain.Ventadetalle;
import test.APIConsumer;

/**
 *
 * @author LEONO
 */
@WebServlet(name = "Cart", urlPatterns = {"/Cart"})
public class Cart extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        if (request.getParameter("T") != null) {
            String a = request.getParameter("T");
            int webid = 0;
            Producto p;
            HttpSession session = request.getSession();

            String usuario = (String) session.getAttribute("usuario");  //Establece usuario de sesión
            String usercompra = usuario;

            if (usuario != null) {
                if (a.equals("O")) {  //Order
                    webid = Integer.parseInt(request.getParameter("id"));
                    if (session.getAttribute("cart") == null) {
                        ArrayList<Item> cart = new ArrayList<>();
                        p = ProductoCad.consultarProducto(session.getAttribute("moneda").toString(), webid);
                        cart.add(new Item(p, 1));
                        session.setAttribute("cart", cart);
                    } else {
                        ArrayList<Item> cart = (ArrayList<Item>) session.getAttribute("cart");
                        int indice = yaExisteProducto(webid, cart);
                        if (indice == -1) {
                            p = ProductoCad.consultarProducto(session.getAttribute("moneda").toString(), webid);
                            cart.add(new Item(p, 1));
                        } else {
                            int cantidad = cart.get(indice).getCantidad() + 1;
                            cart.get(indice).setCantidad(cantidad);
                        }

                        session.setAttribute("cart", cart);
                    }
                } else if (a.equals("D")) {        //Delete
                    webid = Integer.parseInt(request.getParameter("id"));
                    ArrayList<Item> cart = (ArrayList<Item>) session.getAttribute("cart");
                    int indice = yaExisteProducto(webid, cart);
                    cart.remove(indice);
                    session.setAttribute("cart", cart);

                } else if (a.equals("F")) {        //Finish

                    ArrayList<Item> cart = (ArrayList<Item>) session.getAttribute("cart");
                    int indice = yaExisteProducto(webid, cart);
                    System.out.println("*************************");
                    System.out.println("                           Pago Completado");
                    System.out.println("Sesión: " + session.toString());
                    //Recorrer el carrito
                    float stotal = 0;  //Subtotal

                    ArrayList<Ventadetalle> detalles = new ArrayList<>();

                    for (int i = 0; i < cart.size(); i++) {

                        int wid = cart.get(i).getP().getWebid(); //Web Id
                        float pu = cart.get(i).getP().getPrecio();   //Precio Unitario
                        int cant = cart.get(i).getCantidad();    //Cantidad del producto
                        int pt = (int) (pu * cant);    //Precio Total (Cantidad por Precio Unitario)

                        domain.Producto productopojo = new domain.Producto();
                        productopojo.setProductoid(wid);
                        Ventadetalle ventadetalle = new Ventadetalle();
                        ventadetalle.setProducto(productopojo);
                        ventadetalle.setCantidad(cant);
                        detalles.add(ventadetalle);

                        stotal = stotal + pt;

                        System.out.println("Usuario: " + usercompra);
                        System.out.println("Web Id: " + wid + "  Cantidad: " + cant + "   Precio Unitario: " + pu + "   Precio Total: " + pt + " user " + usercompra);
                        Conexion c = new Conexion();
                        Connection con = c.getConexion();
                        float total = (float) (stotal * 1.16); //Total de Cobro (Subtotal más IVA)
                        if (con != null) {
                            System.out.println("Entrando a Conexión");
                            Statement st;
                            st = con.createStatement();

                            st.executeUpdate("insert into tbl_ventas(id_producto, cantidad, precio_unitario, precio_total, usuarioventa) values(" + cart.get(i).getP().getWebid() + "," + cart.get(i).getCantidad() + "," + cart.get(i).getP().getPrecio() + "," + total + "," + "'" + usercompra + "'" + ")");
                            st.close();
                        } else {
                            System.out.println("******Conexión es null");
                        }
                    }
                    try{
                    APIConsumer.generarPedidoCompleto("Solicitando pedido de ecommerce a mercado", detalles);
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                    float total = (float) (stotal * 1.16); //Total de Cobro (Subtotal más IVA)

                    System.out.println("Subtotal:  " + stotal + "   Total de Cobro: " + total);
                    System.out.println("*************************");

                    cart.clear();
                    session.setAttribute("cart", cart);
                    response.setContentType("text/html;charset=UTF-8");
                    request.getRequestDispatcher("Inicio").forward(request, response);
                }
            } else {
                System.out.println("***********No tiene sesión activa de usuario");
                request.getRequestDispatcher("Inicio").forward(request, response);
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    private int yaExisteProducto(int webid, ArrayList<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getP().getWebid() == webid) {
                return i;
            }
        }
        return -1;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
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
