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
public class UsuariosBean extends DAOService implements UsuariosBeanLocal {

    @PersistenceContext(unitName = "MascotasPU")
    private EntityManager em;

    @Override
    public List<Usuario> getUsuarios() {
        return this.em.createNamedQuery("Usuario.findAll", Usuario.class)
                .getResultList();
    }

    @Override
    public Usuario getUsuario(String nombre, String pass) {
        try {
            return this.em.createNamedQuery("Usuario.verificarLogin", Usuario.class)
                    .setParameter("rutUser", nombre)
                    .setParameter("claveUser", pass)
                    .getSingleResult();
        }catch(Exception ex){
            return null;
        }
    }
}
