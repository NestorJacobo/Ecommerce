/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import domain.TblVentas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nesto
 */
@Local
public interface VentasService {
    
    public List<TblVentas> listarVentas();
    
    public TblVentas encontrarVentaPorId(TblVentas ventas);
    
    public void registrarVenta(TblVentas ventas);
    
    public void modificarVenta(TblVentas ventas);
    
    public void eliminarVenta(TblVentas ventas);
    
}
