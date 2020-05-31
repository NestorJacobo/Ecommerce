/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;
import domain.TblCategoria;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author Nesto
 */
@Local
public interface CategoriaService {
    
    public List<TblCategoria> listarCategorias();
    
    public TblCategoria encontrarCategoriaPorId(TblCategoria categorias);
    
    public void registrarCategoria(TblCategoria categorias);
    
    public void modificarCategoria(TblCategoria categorias);
    
    public void eliminarCategoria(TblCategoria categorias);
    
}
