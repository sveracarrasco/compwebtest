/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.mascotas.model;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sarayar
 */
@Local
public interface ProductosDAOLocal extends DAOServiceLocal{

    List<Producto> getProductos();
    
}
