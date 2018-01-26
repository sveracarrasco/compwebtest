/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.mascotas.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sarayar
 */
public class DAOService implements DAOServiceLocal {

    @PersistenceContext(unitName = "MascotasPU")
    protected EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public void merge(Object object) {
        em.merge(object);
        em.flush();
    }



}
