/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import datos.VentasDao;
import domain.TblVentas;
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
@WebService(endpointInterface = "servicio.VentasServiceWs")
public class VentasServiceImpl implements VentasServiceRemote, VentasService, VentasServiceWs{
    
    @Inject
    private VentasDao ventasDao;
    
    @Resource
    private SessionContext contexto;

    @Override
    public List<TblVentas> listarVentas() {
        return ventasDao.findAllVentas();
    }

    @Override
    public TblVentas encontrarVentaPorId(TblVentas ventas) {
        return ventasDao.findVentaById(ventas);
    }

    @Override
    public void registrarVenta(TblVentas ventas) {
        ventasDao.insertVenta(ventas);
    }

    @Override
    public void modificarVenta(TblVentas ventas) {
        try{
            ventasDao.updateVenta(ventas);
        }catch(Throwable t){
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarVenta(TblVentas ventas) {
        ventasDao.deleteVenta(ventas);
    }
    
}
