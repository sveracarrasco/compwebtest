/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.mascotas.beans;

import cl.inacap.mascotas.model.Categoria;
import cl.inacap.mascotas.model.CategoriasDAOLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 * 
 * @author sarayar
 */
@Named(value = "categoriasBean")
@ViewScoped
public class CategoriasBean implements Serializable {

    @EJB
    private CategoriasDAOLocal categoriasDAO;
    private String mensaje = "";
    private String nombre;
    private String btnAccion = "Crear";
    private Categoria catEditada = null;
    private List<Categoria> categorias = new ArrayList<>();

    /**
     * Creates a new instance of CategoriasBean
     */
    public CategoriasBean() {
    }

    @PostConstruct
    public void init() {
        this.categorias = this.categoriasDAO.getCategorias();
        this.btnAccion = "Crear";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void limpiarForm() {
        this.mensaje = "";
        this.btnAccion = "Crear";
        this.nombre = "";
    }

    private boolean validarFormulario() {
        this.nombre = this.nombre.trim();
        if (this.nombre.isEmpty()) {
            this.mensaje = "Debe Ingresar nombre";
            return false;
        } else {
            return true;
        }
    }

    public void editar(Categoria categoria) {
        this.mensaje = "";
        this.nombre = categoria.getNombreCategoria();
        this.catEditada = categoria;
        this.btnAccion = "Actualizar";

    }

    public String getBtnAccion() {
        return btnAccion;
    }

    public void setBtnAccion(String btnAccion) {
        this.btnAccion = btnAccion;
    }

    public Categoria getCatEditada() {
        return catEditada;
    }

    public void setCatEditada(Categoria catEditada) {
        this.catEditada = catEditada;
    }

    public void actuar() {
        if (this.validarFormulario()) {
            if (this.btnAccion.equals("Crear")) {
                this.crearCategoria();
            } else {
                this.actualizarCategoria();
            }
        }
    }

    private void actualizarCategoria() {
        try {
            this.catEditada.setNombreCategoria(this.nombre);
            this.categoriasDAO.merge(this.catEditada);
            this.mensaje = "Categoría Actualizada";
        } catch (Exception ex) {
            this.mensaje = "Error al Actualizar Categoría " + ex.getMessage();
        }
    }

    private void crearCategoria() {
        try {
            Categoria categoria = new Categoria();
            categoria.setNombreCategoria(nombre);
            this.categoriasDAO.persist(categoria);
            this.mensaje = "Categoría Creada";
            this.categorias = this.categoriasDAO.getCategorias();
        } catch (Exception ex) {
            this.mensaje = "Error al Crear Categoría " + ex.getMessage();
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

}
