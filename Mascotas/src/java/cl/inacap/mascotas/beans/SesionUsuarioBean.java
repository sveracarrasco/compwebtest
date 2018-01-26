/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.mascotas.beans;

import cl.inacap.mascotas.model.Usuario;
import cl.inacap.mascotas.model.UsuariosBeanLocal;
import cl.inacap.mascotas.utils.Hash;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author sarayar
 */
@Named(value = "sesionUsuarioBean")
@SessionScoped
public class SesionUsuarioBean implements Serializable {

    @EJB
    private UsuariosBeanLocal usuariosBean;

    private String mensaje;
    private Usuario usuario;
    private String nombre;
    private String clave;
    private String claveRep;
    private String correo;
    private List<String> errores = new ArrayList<>();
    ;
    
    @Inject
    private NavegacionBean navegacionBean;
    private String mensajeEdit;

    /**
     * Creates a new instance of SesionUsuarioBean
     */
    public SesionUsuarioBean() {
    }

    public void editarDatos() {
        this.navegacionBean.navegar("misDatos");
        this.correo = this.usuario.getEmailUser();
        this.clave = "";
        this.claveRep = "";
        this.mensajeEdit = "";
        this.errores = new ArrayList<>();
    }

    public void actualizar() {
        this.errores = new ArrayList<>();
        if (this.correo.trim().isEmpty() || this.correo.split("@").length != 2) {
            errores.add("Debe Ingresar Correo válido");
        }

        if ((!this.clave.trim().isEmpty() || !this.claveRep.trim().isEmpty())
                && !this.clave.equals(this.claveRep)) {
            errores.add("Claves no coinciden");
        }

        if (this.errores.isEmpty()) {
            this.usuario.setEmailUser(this.correo);
            if (!this.clave.isEmpty() && !this.claveRep.isEmpty()) {
                this.usuario.setClave(Hash.md5(this.clave));
            }
            this.usuariosBean.merge(this.usuario);
            this.mensajeEdit = "Datos Actualizados";
        } else {
            this.mensajeEdit = "";
        }

    }

    public void cerrarSesion() {
        this.usuario = null;
    }

    public void login() {
        if (nombre.trim().isEmpty() || clave.trim().isEmpty()) {
            this.mensaje = "Debe ingresar sus credenciales";
        } else {

            this.usuario = this.usuariosBean.getUsuario(nombre, Hash.md5(clave));
            if (this.usuario == null) {
                this.mensaje = "Credenciales Incorrectas";
            } else {
                this.mensaje = "";
            }

        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClaveRep() {
        return claveRep;
    }

    public void setClaveRep(String claveRep) {
        this.claveRep = claveRep;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<String> getErrores() {
        return errores;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }

    public String getMensajeEdit() {
        return mensajeEdit;
    }

    public void setMensajeEdit(String mensajeEdit) {
        this.mensajeEdit = mensajeEdit;
    }

}
