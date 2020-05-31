/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplojaas;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Dann
 */
@Named(value = "groupBean")
@Dependent
public class groupBean
{

    /**
     * Creates a new instance of groupBean
     */
    public groupBean()
    {
    }
    
}
