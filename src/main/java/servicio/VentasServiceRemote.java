/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

/**
 *
 * @author Nesto
 */
import java.util.List;
import javax.ejb.Remote;
import domain.TblVentas;

public interface VentasServiceRemote {
    
    public List<TblVentas> listarVentas();
    
    public TblVentas encontrarVentaPorId(TblVentas ventas);
        
    public void registrarVenta(TblVentas ventas);
    
    public void modificarVenta(TblVentas ventas);
    
    public void eliminarVenta(TblVentas ventas);
    
}
