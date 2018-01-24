/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.usuariosApp.model;

import java.util.List;

/**
 *
 * @author sarayar
 */

public interface IUtilidad {
    public Persona loguear(String rut, String clave, List<Persona> personas);
    public Persona buscar(String rut, List<Persona> personas);
}
