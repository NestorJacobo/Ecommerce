/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.TblCategoria;
import java.util.List;
/**
 *
 * @author Nesto
 */
public interface CategoriasDao {
    
    public List<TblCategoria> findAllCategorias();
    
    public TblCategoria findCategoriaById(TblCategoria categorias);
        
    public void insertCategoria(TblCategoria categorias);
    
    public void updateCategoria(TblCategoria categorias);
    
    public void deleteCategoria(TblCategoria categorias);
    
}
