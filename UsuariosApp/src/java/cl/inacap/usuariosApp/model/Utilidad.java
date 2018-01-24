/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.usuariosApp.model;

import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author sarayar
 */
@ApplicationScoped
public class Utilidad implements IUtilidad{

    @Override
    public Persona loguear(String rut, String clave, List<Persona> personas) {
        List<Persona> filtro = personas.stream()
                .filter(p->p.getRut().equals(rut) && p
                        .getClave().equals(clave))
                .collect(Collectors.toList());
        return filtro.isEmpty()? null: filtro.get(0);
    }

    @Override
    public Persona buscar(String rut, List<Persona> personas) {
           List<Persona> filtro = personas.stream()
                .filter(p->p.getRut().equals(rut))
                .collect(Collectors.toList());
        return filtro.isEmpty()? null: filtro.get(0);
    }
    
}
