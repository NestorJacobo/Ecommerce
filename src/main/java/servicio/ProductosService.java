/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;
import domain.TblProducto;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author Nesto
 */
@Local
public interface ProductosService {
    
    public List<TblProducto> listarProductos();
    
    public TblProducto encontrarProductoPorId(TblProducto productos);
    
    public void registrarProducto(TblProducto productos);
    
    public void modificarProducto(TblProducto productos);
    
    public void eliminarProducto(TblProducto productos);
    
}
