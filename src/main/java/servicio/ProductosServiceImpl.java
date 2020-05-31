/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import datos.ProductosDao;
import domain.TblProducto;
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
@WebService(endpointInterface = "servicio.ProductosServiceWS")
public class ProductosServiceImpl implements ProductosServiceRemote, ProductosService, ProductosServiceWS{
    
    @Inject
    private ProductosDao productosDao;
    
    @Resource
    private SessionContext contexto;

    @Override
    public List<TblProducto> listarProductos() {
        return productosDao.findAllVentas();
    }

    @Override
    public TblProducto encontrarProductoPorId(TblProducto productos) {
        return productosDao.findProductoById(productos);
    }

    @Override
    public void registrarProducto(TblProducto productos) {
        productosDao.insertProducto(productos);
    }

    @Override
    public void modificarProducto(TblProducto productos) {
        try{
            productosDao.updateProducto(productos);
        }catch(Throwable t){
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarProducto(TblProducto productos) {
        productosDao.deleteProducto(productos);
    }
    
    
}
