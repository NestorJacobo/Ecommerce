/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import domain.TblVentas;
/**
 *
 * @author Nesto
 */
@WebService
public interface VentasServiceWs {
    
    @WebMethod
    public List<TblVentas> listarVentas();
    
}
