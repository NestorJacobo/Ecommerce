/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import conexion.Conexion;
import domain.TblProducto;
import domain.Producto;
import domain.Ventas;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;


/**
 *
 * @author Nesto
 */
public class TestProductosServiceRS {

    private static final String URL_BASE = "https://69b1b8c516e6.ngrok.io/ERPmercadoPM/webresources";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Producto producto;
    private static List<Producto> productos;
    private static Invocation.Builder invocationBuilder;
    private static Response response;
    private static int stock = 1;
    private static int nuevo = 1;
    private static int recomendado = 1;
    private static int visible = 1;
    private static int codigo_marca = 1;
    
    

    public static void main(String[] args) throws SQLException, UnsupportedEncodingException, JsonProcessingException {

        /*cliente = ClientBuilder.newClient();
        webTarget = cliente.target(URL_BASE).path("/productos");
        invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        response = invocationBuilder.get();
        System.out.println("Respuesta: " + response.getStatus());
        productos = new ObjectMapper().
                readValue(response.readEntity(String.class), new TypeReference<List<Producto>>() {
                });
        imprimirProductos(productos);
        

        Conexion c = new Conexion();
        Connection con = c.getConexion();
        Statement st;
        st = con.createStatement();
        st.executeUpdate("delete from tbl_producto");

            for (int i = 0; i < productos.size(); i++) {
                
                System.out.println("Entrando a la conexion");

                                                
                st.executeUpdate("insert into tbl_producto(webid, nombre, precio, precionuevo, stock, nuevo, recomendado, descripcion, visible, codigo_marca, codigo_categoria, img, unidad_medida) "
                        + "values(" + productos.get(i).getProductoid() + ", " + "'" + productos.get(i).getNombre() + "'" + ", " + productos.get(i).getPrecioUnitario() + ", " + productos.get(i).getPrecionuevo() + "," + stock + "," + nuevo + "," + recomendado + ", " + "'" + productos.get(i).getDescripcion() + "'" + "," + visible + "," + codigo_marca + "," + productos.get(i).getCategoriaid().getCategoriaid() + ", " + "'" + productos.get(i).getImg() + "'" + ", " + "'" + productos.get(i).getUnidadMedida() + "'" + ")");

                System.out.println("Producto registrado " + productos.get(i));
            }

                     
            System.out.println("Cerrando la conexion");
            st.close();*/
                    

    }

    public void ServicioProductos() throws SQLException, JsonProcessingException {
        cliente = ClientBuilder.newClient();
        webTarget = cliente.target(URL_BASE).path("/productos");
        invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        response = invocationBuilder.get();
        System.out.println("Respuesta: " + response.getStatus());
        productos = new ObjectMapper().
                readValue(response.readEntity(String.class), new TypeReference<List<Producto>>() {
                });
        imprimirProductos(productos);
        

        Conexion c = new Conexion();
        Connection con = c.getConexion();
        Statement st;
        st = con.createStatement();
        st.executeUpdate("delete from tbl_ventas");
        st.executeUpdate("delete from tbl_producto");
        

            for (int i = 0; i < productos.size(); i++) {
                
                System.out.println("Entrando a la conexion");

                                                
                st.executeUpdate("insert into tbl_producto(webid, nombre, precio, precionuevo, stock, nuevo, recomendado, descripcion, visible, codigo_marca, codigo_categoria, img, unidad_medida) "
                        + "values(" + productos.get(i).getProductoid() + ", " + "'" + productos.get(i).getNombre() + "'" + ", " + productos.get(i).getPrecioUnitario() + ", " + productos.get(i).getPrecionuevo() + "," + stock + "," + nuevo + "," + recomendado + ", " + "'" + productos.get(i).getDescripcion() + "'" + "," + visible + "," + codigo_marca + "," + productos.get(i).getCategoriaid().getCategoriaid() + ", " + "'" + productos.get(i).getImg() + "'" + ", " + "'" + productos.get(i).getUnidadMedida() + "'" + ")");

                System.out.println("Producto registrado " + productos.get(i));
            }

                     
            System.out.println("Cerrando la conexion");
            st.close();
    }

    private static void imprimirProductos(List<Producto> productos) {
        for (Producto p : productos) {
            System.out.println("Productos: " + p);
        }
    }


}
