/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import domain.TblProducto;

/**
 *
 * @author Nesto
 */
@Stateless
public class ProductosDaoImpl implements ProductosDao{
    
    @PersistenceContext(unitName="com.mycompany_ejemploJAAS_war_1.0-SNAPSHOTPU")
    EntityManager em;

    @Override
    public List<TblProducto> findAllVentas() {
        return em.createNamedQuery("TblProducto.findAll").getResultList();
    }

    @Override
    public TblProducto findProductoById(TblProducto productos) {
        return em.find(TblProducto.class, productos.getWebid());
    }

    @Override
    public void insertProducto(TblProducto productos) {
        em.persist(productos);
    }

    @Override
    public void updateProducto(TblProducto productos) {
        em.merge(productos);
    }

    @Override
    public void deleteProducto(TblProducto productos) {
        em.remove(em.merge(productos));
    }
    
}
