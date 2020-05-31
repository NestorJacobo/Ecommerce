/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import domain.Ventadetalle;
/**
 *
 * @author Nesto
 */

@Stateless 
public class VentasDetalleDaoImpl implements VentasDetalleDao{
    @PersistenceContext(unitName="com.mycompany_ejemploJAAS_war_1.0-SNAPSHOTPU")
    EntityManager em;

    @Override
    public List<Ventadetalle> findAllVentasDetalle() {
        return (List<Ventadetalle>) em.createQuery("select * from tbl_ventas").getResultList();
    }

    
}
