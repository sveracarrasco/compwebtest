/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.mascotas.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author sarayar
 */
@Named(value = "navegacionBean")
@SessionScoped
public class NavegacionBean implements Serializable {
    private String ventanaActual;
    
    /**
     * Creates a new instance of NavegacionBean
     */
    public NavegacionBean() {
    }
    
    @PostConstruct
    public void init(){
        this.ventanaActual = "index";
    }
    
    public void navegar(String destino){
        this.ventanaActual = destino;
    }

    public String getVentanaActual() {
        return ventanaActual;
    }

    public void setVentanaActual(String ventanaActual) {
        this.ventanaActual = ventanaActual;
    }
    
    
    
}
