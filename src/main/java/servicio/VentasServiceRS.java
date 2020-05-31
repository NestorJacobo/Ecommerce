/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import domain.TblVentas;
/**
 *
 * @author Nesto
 */
@Path("/ventas")
@Stateless
public class VentasServiceRS {
    
    @Inject
    private VentasService ventasService;
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TblVentas> listarVentas() {
        return ventasService.listarVentas();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /ventas/{id} 
    public TblVentas encontrarVentaPorId(@PathParam("id") int id) {
        System.out.println("Buscada por id");
        return ventasService.encontrarVentaPorId(new TblVentas(id));
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarVenta(TblVentas ventas) {
        try {
            ventasService.registrarVenta(ventas);
            return Response.ok().entity(ventas).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarVenta(@PathParam("id") int id, TblVentas ventaModificada) {
        try {
            TblVentas ventas = ventasService.encontrarVentaPorId(new TblVentas(id));
                    //personaService.encontrarPersonaPorId(new Persona(id));
            if (ventas != null) {
                ventasService.modificarVenta(ventaModificada);
                return Response.ok().entity(ventaModificada).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminarVentaPorId(@PathParam("id") int id) {
        try {
            ventasService.eliminarVenta(new TblVentas(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.NOT_FOUND).build();
        }
    }
    
}
