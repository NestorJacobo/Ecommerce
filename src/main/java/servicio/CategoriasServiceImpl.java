/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import datos.CategoriasDao;
import domain.TblCategoria;
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
@WebService(endpointInterface = "servicio.CategoriasServiceWs")
public class CategoriasServiceImpl implements CategoriasServiceRemote, CategoriasServiceWs, CategoriaService{
    @Inject
    private CategoriasDao categoriasDao;
    
    @Resource
    private SessionContext contexto;

    @Override
    public List<TblCategoria> listarCategorias() {
        return categoriasDao.findAllCategorias();
    }

    @Override
    public TblCategoria encontrarCategoriaPorId(TblCategoria categorias) {
        return categoriasDao.findCategoriaById(categorias);
    }

    @Override
    public void registrarCategoria(TblCategoria categorias) {
        categoriasDao.insertCategoria(categorias);
    }

    @Override
    public void modificarCategoria(TblCategoria categorias) {
        try{
            categoriasDao.updateCategoria(categorias);
        }catch(Throwable t){
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarCategoria(TblCategoria categorias) {
        categoriasDao.deleteCategoria(categorias);
    }

    
}
