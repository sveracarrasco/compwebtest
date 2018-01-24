/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.usuariosApp.beans;

import cl.inacap.usuariosApp.model.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sarayar
 */
@Local
public interface PersonaBeanLocal {
    
    public Persona buscar(String rut);
    public Persona loguear(String rut, String clave);
    public void editar(Persona persona);
    public String agregarPersona(Persona persona);
    public List<Persona> getPersonaList();
}
