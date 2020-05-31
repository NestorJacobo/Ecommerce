/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import datos.VentasDetalleDao;
import domain.TblVentas;
import domain.Ventadetalle;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
/**
 *
 * @author Nesto
 */
@Stateless
@WebService(endpointInterface = "servicio.VentasDetalleServiceWs")
public class VentasDetalleServiceImpl implements VentasDetalleService, VentasDetalleServiceWs{

    @Inject
    private VentasDetalleDao ventasDetalleDao;
    
    @Resource
    private SessionContext contexto;
    
    @Override
    public List<Ventadetalle> listarVentasDetalle() {
        return ventasDetalleDao.findAllVentasDetalle();
    }

    
}
