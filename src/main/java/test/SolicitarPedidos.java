/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.Ordenventa;
import domain.Producto;
import domain.Ventadetalle;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nesto
 */
public class SolicitarPedidos {
    public static void main(String[] args) throws JsonProcessingException {
        /*Ordenventa ordenventa = pruebaGenerarPedido();
        System.out.println(ordenventa);
        Response response = pruebaAgregarDetallesAlPedido(ordenventa);
        System.out.println("Solicitando pedido...");
        Response responseSolicitar = APIConsumer.concluirPedido(ordenventa);
        System.out.println("Respuesta: "+responseSolicitar.getStatus());*/
        try {
            ArrayList<Ventadetalle> detalles = new ArrayList<>();
            for(long i=40; i<42; i++){
                Producto producto = new Producto();
                producto.setProductoid((int) i);
                Ventadetalle ventadetalle = new Ventadetalle();
                ventadetalle.setProducto(producto);
                ventadetalle.setCantidad(10);
                detalles.add(ventadetalle);
            }
            Ordenventa ordenventa = APIConsumer.generarPedidoCompleto("Realizando prueba de solicitud de productos", detalles);
            System.out.println(ordenventa);
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(SolicitarPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
