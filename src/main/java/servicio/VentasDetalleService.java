/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import domain.Ventadetalle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nesto
 */
@Local
public interface VentasDetalleService {
    
    public List<Ventadetalle> listarVentasDetalle();
    
}
