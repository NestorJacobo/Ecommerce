/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import domain.Ventadetalle;
import java.util.List;
/**
 *
 * @author Nesto
 */
public interface VentasDetalleDao {
    public List<Ventadetalle> findAllVentasDetalle();
    
}
