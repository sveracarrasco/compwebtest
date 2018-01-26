/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.mascotas.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sarayar
 */
@Stateless
public class CategoriasDAO extends DAOService implements CategoriasDAOLocal {

    @Override
    public List<Categoria> getCategorias() {
        return this.em.createNamedQuery("Categoria.findAll",
                Categoria.class).getResultList();
    }

    @Override
    public Categoria obtener(int id) {
        return this.em.find(Categoria.class, id);
    }

}
