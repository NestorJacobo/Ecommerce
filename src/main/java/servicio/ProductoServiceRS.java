/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import domain.TblProducto;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Nesto
 */
@Path("/productos")
@Stateless
public class ProductoServiceRS {
    
    @Inject
    private ProductosService productosService;
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TblProducto> listarProductos() {
        return productosService.listarProductos();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /ventas/{id} 
    public TblProducto encontrarProductoPorId(@PathParam("id") int id) {
        System.out.println("Busqueda por id");
        return productosService.encontrarProductoPorId(new TblProducto(id));
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarProducto(TblProducto producto) {
        try {
            productosService.registrarProducto(producto);
            return Response.ok().entity(producto).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarProducto(@PathParam("id") int id, TblProducto ProductoModificado) {
        try {
            TblProducto productos = productosService.encontrarProductoPorId(new TblProducto(id));
                    //personaService.encontrarPersonaPorId(new Persona(id));
            if (productos != null) {
                productosService.modificarProducto(ProductoModificado);
                return Response.ok().entity(ProductoModificado).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminarProductoPorId(@PathParam("id") int id) {
        try {
            productosService.eliminarProducto(new TblProducto(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
}
