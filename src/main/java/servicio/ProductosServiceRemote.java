/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import javax.ejb.Remote;
import domain.TblProducto;
/**
 *
 * @author Nesto
 */
@Remote
public interface ProductosServiceRemote {
    
    public List<TblProducto> listarProductos();
    
    public TblProducto encontrarProductoPorId(TblProducto productos);
        
    public void registrarProducto(TblProducto productos);
    
    public void modificarProducto(TblProducto productos);
    
    public void eliminarProducto(TblProducto productos);
    
}
