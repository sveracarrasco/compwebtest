/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.usuariosApp.beans;

import cl.inacap.usuariosApp.model.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Singleton;

/**
 *
 * @author sarayar
 */
@Singleton
public class PersonaBean implements PersonaBeanLocal {

    private final List<Persona> personas = new ArrayList<>();

    public PersonaBean() {
        for (int i = 1; i <= 5; ++i) {
            this.personas.add(new Persona("Nomb " + i, "1-" + i, "Admin", "per" + i,
                     "1" + i, true));
        }
    }

    @Override
    public Persona loguear(String rut, String clave) {
        List<Persona> filtro = personas.stream()
                .filter(p -> p.getRut().equals(rut) && p
                .getClave().equals(clave))
                .collect(Collectors.toList());
        return filtro.isEmpty() ? null : filtro.get(0);
    }

    @Override
    public Persona buscar(String rut) {
        List<Persona> filtro = personas.stream()
                .filter(p -> p.getRut().equals(rut))
                .collect(Collectors.toList());
        return filtro.isEmpty() ? null : filtro.get(0);
    }

    @Override
    public void editar(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String agregarPersona(Persona persona) {
        Persona p = this.buscar(persona.getRut());
        if(p == null){
            this.personas.add(p);
            return "Persona creada exitosamente";
        } else {
            return "Rut ya fue registrado";
        }
    }

    @Override
    public List<Persona> getPersonaList() {
        return this.personas;
    }

}
