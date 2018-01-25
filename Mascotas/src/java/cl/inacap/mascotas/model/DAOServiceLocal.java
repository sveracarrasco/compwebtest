/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.mascotas.model;

import javax.ejb.Local;

/**
 *
 * @author sarayar
 */
public interface DAOServiceLocal {

    public void persist(Object object);

    public void merge(Object object);

}
