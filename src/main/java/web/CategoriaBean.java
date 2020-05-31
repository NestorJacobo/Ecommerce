/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import domain.TblCategoria;
import servicio.CategoriaService;
/**
 *
 * @author Nesto
 */
@Named("categoriaBean")
@RequestScoped
public class CategoriaBean {
    
    @Inject
    private CategoriaService categoriaService;

    List<TblCategoria> categorias;
    
    public void categoriasList(){
        this.categorias = categoriaService.listarCategorias();
    }
    
    
}
