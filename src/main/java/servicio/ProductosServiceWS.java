/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import domain.TblProducto;
/**
 *
 * @author Nesto
 */
@WebService
public interface ProductosServiceWS {
    
    @WebMethod
    public List<TblProducto> listarProductos();
    
}
