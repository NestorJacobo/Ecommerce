/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Nesto
 */
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long categoriaid;
	
	public Categoria() {
    }
	
	public Long getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(Long categoriaid) {
        this.categoriaid = categoriaid;
    }

}