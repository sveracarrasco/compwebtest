/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.ejercicioJPA.beans;

import cl.inacap.ejercicioJPA.model.Categoria;
import cl.inacap.ejercicioJPA.model.Perfil;
import cl.inacap.ejercicioJPA.model.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sarayar
 */
@Stateless
public class ServicioBean implements ServicioBeanLocal {

    @PersistenceContext(unitName = "EjercicioJPAPU")
    private EntityManager em;
    
    
    @Override
    public List<Perfil> getPerfiles() {
        return this.em.createQuery("select p from Perfil p").getResultList();
    }

    @Override
    public List<Producto> getProductos() {
        return this.em.createNamedQuery("Producto.findAll", Producto.class).getResultList();
    }

    @Override
    public List<Categoria> getCattegorias() {
        return this.em.createNamedQuery("Categoria.findAll", Categoria.class).getResultList();
    }

    @Override
    public void save(Object o) {
        
        this.em.persist(o);
    }

    @Override
    public Producto buscarProducto(int id) {
        return this.em.find(Producto.class, id);
    }

    @Override
    public Perfil buscarPerfil(int id) {
        return this.em.find(Perfil.class, id);
    }

    @Override
    public Categoria buscarCategoria(int id) {
        return this.em.find(Categoria.class, id);
    }
    
}
