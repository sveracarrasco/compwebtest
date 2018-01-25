/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.mascotas.model;

import cl.inacap.mascotas.beans.ProductosBean;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author sarayar
 */
@Stateless
public class ProductosDAO extends DAOService implements ProductosDAOLocal {

    @Override
    public List<Producto> getProductos() {
        return this.em.createNamedQuery("Producto.findAll"
                , Producto.class).getResultList();
    }

    
}
