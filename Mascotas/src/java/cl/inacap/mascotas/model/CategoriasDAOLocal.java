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
public interface CategoriasDAOLocal extends DAOServiceLocal{

    public List<Categoria> getCategorias();


    public Categoria obtener(int id);

}
