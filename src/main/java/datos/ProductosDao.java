/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.TblProducto;
import java.util.List;

/**
 *
 * @author Nesto
 */
public interface ProductosDao {
    
    public List<TblProducto> findAllVentas();
    
    public TblProducto findProductoById(TblProducto productos);
        
    public void insertProducto(TblProducto productos);
    
    public void updateProducto(TblProducto productos);
    
    public void deleteProducto(TblProducto productos);
    
}
