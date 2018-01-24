/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.demo01.modelo;

/**
 *
 * @author sarayar
 */
public class Persona {
    
    private String nombre;
    private int edad;
    private String clave;

    public Persona() {
    }

    public Persona(String nombre, int edad, String clave) {
        this.nombre = nombre;
        this.edad = edad;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
}
