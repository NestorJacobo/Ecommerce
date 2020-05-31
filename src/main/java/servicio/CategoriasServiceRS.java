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
import domain.TblCategoria;

/**
 *
 * @author Nesto
 */
@Path("/categorias")
@Stateless
public class CategoriasServiceRS {
    
    @Inject
    private CategoriaService categoriasService;
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TblCategoria> listarCategorias() {
        return categoriasService.listarCategorias();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /ventas/{id} 
    public TblCategoria encontrarCategoriaPorId(@PathParam("id") int id) {
        System.out.println("Busqueda por id");
        return categoriasService.encontrarCategoriaPorId(new TblCategoria(id));
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarCategoria(TblCategoria categorias) {
        try {
            categoriasService.registrarCategoria(categorias);
            return Response.ok().entity(categorias).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarCategoria(@PathParam("id") int id, TblCategoria categoriaModificada) {
        try {
            TblCategoria categorias = categoriasService.encontrarCategoriaPorId(new TblCategoria(id));
                    //personaService.encontrarPersonaPorId(new Persona(id));
            if (categorias != null) {
                categoriasService.modificarCategoria(categoriaModificada);
                return Response.ok().entity(categoriaModificada).build();
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
    public Response eliminarCategoriaPorId(@PathParam("id") int id) {
        try {
            categoriasService.eliminarCategoria(new TblCategoria(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.NOT_FOUND).build();
        }
    }
    
}
