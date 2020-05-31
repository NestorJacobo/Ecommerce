/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.Categorias;
import domain.TblCategoria;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nesto
 */
public class TestCategoriaServiceRS {

    private static final String URL_BASE = "http://192.168.0.28:8080/ClienteRS/resources";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Categorias categoria;
    private static List<Categorias> categorias;
    private static Invocation.Builder invocationBuilder;
    private static Response response;

    public static void main(String[] args) throws SQLException {
        cliente = ClientBuilder.newClient();

        //Leer una persona (GET)
        webTarget = cliente.target(URL_BASE).path("/categorias");
        //Proporcionamos un idVenta valido
        categoria = webTarget.path("/2").request(MediaType.APPLICATION_XML).get(Categorias.class);

        System.out.println(webTarget);

        System.out.println("VentaRecuperada " + categoria);

        //Leer todas las personas método GET redEntity de tipo List 
        categorias = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Categorias>>() {
        });
        System.out.println("\nCategorias recuperadas ");
        imprimirCategorias(categorias);

        Conexion c = new Conexion();
        Connection con = c.getConexion();
        Statement st;
        st = con.createStatement();
        st.executeUpdate("delete from tbl_categoria");

        for (int i = 0; i < categorias.size(); i++) {

                System.out.println("Entrando a la conexion");
                st.executeUpdate("insert into tbl_categoria(codigo, nombre, visible, categoria_superior) values(" + categorias.get(i).getCodigo() + ", " + "'" + categorias.get(i).getNombre() + "'" + ", " + categorias.get(i).getVisible() + "," + categorias.get(i).getCategoria_superior() + ")");
                

            System.out.println("Categoria registrada " + categorias.get(i));
        }
        
        System.out.println("Cerrando la conexion");
        st.close();

    }
    
    public void IngresarCat() throws SQLException{
        
        categorias = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Categorias>>() {
        });
        System.out.println("\nCategorias recuperadas ");
        imprimirCategorias(categorias);

        Conexion c = new Conexion();
        Connection con = c.getConexion();
        Statement st;
        st = con.createStatement();
        st.executeUpdate("delete from tbl_Categoria");

        for (int i = 0; i < categorias.size(); i++) {

                System.out.println("Entrando a la conexion");
                st.executeUpdate("insert into tbl_categoria(codigo, nombre, visible, categoria_superior) values(" + categorias.get(i).getCodigo() + ", " + "'" + categorias.get(i).getNombre() + "'" + ", " + categorias.get(i).getVisible() + "," + categorias.get(i).getCategoria_superior() + ")");
                

            System.out.println("Categoria registrada " + categorias.get(i));
        }
        
        System.out.println("Cerrando la conexion");
        st.close();
        
    }

    private static void imprimirCategorias(List<Categorias> categorias) {
        for (Categorias c : categorias) {
            System.out.println("Categorias: " + c);
        }
    }

}