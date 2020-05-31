/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import domain.TblVentas;
/**
 *
 * @author Nesto
 */
@Stateless 
public class VentasDaoImpl implements VentasDao{
    
    @PersistenceContext(unitName="com.mycompany_ejemploJAAS_war_1.0-SNAPSHOTPU")
    EntityManager em;

    @Override
    public List<TblVentas> findAllVentas() {
        return em.createNamedQuery("TblVentas.findAll").getResultList();
    }

    @Override
    public TblVentas findVentaById(TblVentas ventas) {
        return em.find(TblVentas.class, ventas.getIdVenta());
    }

    @Override
    public void insertVenta(TblVentas ventas) {
        em.persist(ventas);
    }

    @Override
    public void updateVenta(TblVentas ventas) {
        em.merge(ventas);
    }

    @Override
    public void deleteVenta(TblVentas ventas) {
        em.remove(em.merge(ventas));
    }
    
}
