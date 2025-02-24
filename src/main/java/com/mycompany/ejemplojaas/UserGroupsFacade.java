/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplojaas;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dann
 */
@Stateless
public class UserGroupsFacade extends AbstractFacade<UserGroups>
{

    @PersistenceContext(unitName = "com.mycompany_ejemploJAAS_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public UserGroupsFacade()
    {
        super(UserGroups.class);
    }
    
}
