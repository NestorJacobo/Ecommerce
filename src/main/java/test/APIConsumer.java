/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.Ordenventa;
import domain.Ventadetalle;
import java.util.ArrayList;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import domain.Cliente;

/**
 *
 * @author Nesto
 */
public class APIConsumer {

    private static final String URL_BASE = "http://80e4558a2e1b.ngrok.io/ERPmercadoPM/webresources";
    private static WebTarget webTarget;
    private static Client clientHttp;
    private static Invocation.Builder invocationBuilder;
    

    public static Response realizarPedido(Ordenventa ordenventa) {
        System.out.println("Proveedores -> Realizando pedido a subproveedores...");
        clientHttp = ClientBuilder.newClient();
        webTarget = clientHttp.target(URL_BASE).path("/pedidos");
        invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(
                Entity.entity(ordenventa, MediaType.APPLICATION_JSON));
        System.out.println("Respuesta: " + response.getStatus());
        return response;
    }

    public static Response agregarDetallesAlPedido(Ordenventa ordenventa) {
        System.out.println("Proveedores -> Agregando detalles al pedido");
        if (ordenventa.getVentadetalleCollection() == null) {
            return null;
        }
        clientHttp = ClientBuilder.newClient();
        webTarget = clientHttp.target(URL_BASE).path("/pedidos/detalles");
        invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.put(Entity.entity(ordenventa,
                MediaType.APPLICATION_JSON));
        System.out.println("Respuesta: " + response.getStatus());
        return response;
    }

    public static Response concluirPedido(Ordenventa ordenventa) {
        System.out.println("Solicitando el pedido...");
        clientHttp = ClientBuilder.newClient();
        webTarget = clientHttp.target(URL_BASE).path("/pedidos/solicitar");
        invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(ordenventa, MediaType.APPLICATION_JSON));
        System.out.println("Respuesta: " + response.getStatus());
        return response;
    }

    public static Ordenventa generarPedidoCompleto(String descripcion, ArrayList<Ventadetalle> ventaDetalleList) throws Exception {
        Ordenventa ordenventa = new Ordenventa();
        Cliente cliente = new Cliente();
        cliente.setEmail("ecommerce@company.mx");
        ordenventa.setClienteid(cliente);
        ordenventa.setDescripcion(descripcion);
        ordenventa.setVentadetalleCollection(ventaDetalleList);
        Response responseOrdenVenta = APIConsumer.realizarPedido(ordenventa);
        if (responseOrdenVenta.getStatus() != 200) {
            String msg = responseOrdenVenta.readEntity(String.class);
            throw new Exception("Whoops!!. Error al realizar un pedido!\n" + msg);
        }
        // DETALLES
        Ordenventa ordenVentaResult = responseOrdenVenta.readEntity(Ordenventa.class);
        ordenVentaResult.setVentadetalleCollection(ventaDetalleList);
        Response responseDetalles = APIConsumer.agregarDetallesAlPedido(ordenVentaResult);
        if (responseDetalles.getStatus() != 200) {
            String msg = responseDetalles.readEntity(String.class);
            throw new Exception("Whoops!!. Error al añadir los detalles al pedido!\n" + msg);
        }
        // CONLUYENDO PEDIDO Y RECIBIENDO LA FACTURA
        Response responseCompletarPedido = APIConsumer.concluirPedido(ordenVentaResult);
        if (responseCompletarPedido.getStatus() != 200) {
            throw new Exception("Whoops!!. Error al concluir el pedido!");
        }
        return ordenVentaResult;
    }

}
