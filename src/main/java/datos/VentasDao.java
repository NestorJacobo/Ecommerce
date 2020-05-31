/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.TblVentas;
import java.util.List;

/**
 *
 * @author Nesto
 */
public interface VentasDao {
    
    public List<TblVentas> findAllVentas();
    
    public TblVentas findVentaById(TblVentas ventas);
        
    public void insertVenta(TblVentas ventas);
    
    public void updateVenta(TblVentas ventas);
    
    public void deleteVenta(TblVentas ventas);
    
}
