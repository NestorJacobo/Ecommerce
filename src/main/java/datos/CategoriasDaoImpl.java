/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import domain.TblCategoria;

/**
 *
 * @author Nesto
 */
@Stateless
public class CategoriasDaoImpl implements CategoriasDao{
    
    @PersistenceContext(unitName="com.mycompany_ejemploJAAS_war_1.0-SNAPSHOTPU")
    EntityManager em;

    @Override
    public List<TblCategoria> findAllCategorias() {
        return em.createNamedQuery("TblCategoria.findAll").getResultList();
    }

    @Override
    public TblCategoria findCategoriaById(TblCategoria categorias) {
        return em.find(TblCategoria.class, categorias.getCodigo());
    }

    @Override
    public void insertCategoria(TblCategoria categorias) {
        em.persist(categorias);
    }

    @Override
    public void updateCategoria(TblCategoria categorias) {
        em.merge(categorias);
    }

    @Override
    public void deleteCategoria(TblCategoria categorias) {
        em.remove(em.merge(categorias));
    }
    
}
