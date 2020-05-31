/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.TblVentas;
import domain.Ventas;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Nesto
 */
public class TestPersonaServiceRS {
    
    private static final String URL_BASE = "http://localhost:8080/EcommerceJEE/webservice";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Ventas venta;
    private static List<Ventas> ventas;
    private static Invocation.Builder invocationBuilder;
    private static Response response;
    
    public static void main(String[] args) {
        cliente = ClientBuilder.newClient();
        
        //Leer una persona (GET)
        webTarget = cliente.target(URL_BASE).path("/ventas");
        //Proporcionamos un idVenta valido
        venta = webTarget.path("/2").request(MediaType.APPLICATION_XML).get(Ventas.class);
        
        System.out.println(webTarget);
        
        System.out.println("VentaRecuperada " + venta);
        
        //Leer todas las personas método GET redEntity de tipo List 
        
        ventas = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Ventas>>(){});
        System.out.println("\nVentas recuperadas ");
        imprimirVentas(ventas);
        
        //Agregar una Venta
        Ventas nuevaVenta = new Ventas();
        nuevaVenta.setIdProducto(20);
        nuevaVenta.setCantidad(2);
        nuevaVenta.setPrecioUnitario(40);
        nuevaVenta.setPrecioTotal(80);
        nuevaVenta.setUsuarioventa("admin");
        
        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post(Entity.entity(nuevaVenta, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println(response.getStatus());
        
        //Recuperamos la venta recien agregada para despues modificarla y al final eliminarla
        
        Ventas ventaRecuperada = response.readEntity(Ventas.class);
        System.out.println("Persona Agregada" + ventaRecuperada);
        
        //Modificar la venta recien agregada PUT
        
        Ventas ventasModificar = ventaRecuperada;
        ventasModificar.setCantidad(3);
        String pathId = "/" + ventasModificar.getIdVenta();
        invocationBuilder = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(ventasModificar, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println(response.getStatus());
        System.out.println("Venta modificada " + response.readEntity(Ventas.class));
        
        //Eliminar una persona recuperada anteriormente
        
        Ventas ventaEliminar = ventaRecuperada;
        String pathEliminarId = "/" + ventaEliminar.getIdVenta();
        invocationBuilder = webTarget.path(pathEliminarId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();
        System.out.println("");
        System.out.println(response.getStatus());
        System.out.println("Persona Eliminada " + ventaEliminar);
    }
    
    private static void imprimirVentas(List<Ventas> ventas){
        for(Ventas v: ventas){
            System.out.println("Ventas: " + v);
        }
    }
    
}
