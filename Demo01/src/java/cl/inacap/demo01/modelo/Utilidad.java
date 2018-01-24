/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.demo01.modelo;

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
    public Persona loguear(String nombre, String clave, List<Persona> lista) {
               List<Persona> personas =  lista.stream()
               .filter(p -> p.getNombre()
                       .equals(nombre) && p.getClave() != null &&  p.getClave().equals(clave))
               .collect(Collectors.toList());
        return personas.isEmpty()? null: personas.get(0);
    }
    
}
