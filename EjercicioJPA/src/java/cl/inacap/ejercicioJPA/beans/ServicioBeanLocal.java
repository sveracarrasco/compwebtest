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
import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sarayar
 */
@Local
public interface ServicioBeanLocal {

    public List<Perfil> getPerfiles();
    public List<Producto> getProductos();
    public List<Categoria> getCattegorias();
    void save(Object o);
    Producto buscarProducto(int id);
    Perfil buscarPerfil(int id);
    Categoria buscarCategoria(int id);
}
