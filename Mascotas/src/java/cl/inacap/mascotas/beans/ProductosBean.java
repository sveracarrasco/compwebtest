/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.mascotas.beans;

import cl.inacap.mascotas.model.Categoria;
import cl.inacap.mascotas.model.CategoriasDAOLocal;
import cl.inacap.mascotas.model.Producto;
import cl.inacap.mascotas.model.ProductosDAOLocal;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author sarayar
 */
@Named(value = "productosBean")
@ViewScoped
public class ProductosBean implements Serializable {

    @EJB
    private CategoriasDAOLocal categoriasDAO;
    @EJB
    private ProductosDAOLocal productosDAO;
    private Part archivo;
    private String mensaje = "";
    private String nombre;
    private int precio;
    private int unidades;
    private Integer idCategoriaSeleccionada;
    private String descripcion;
    private String btnAccion = "Crear";
    private Producto productoEditado = null;
    private Categoria categoriaSeleccionada = null;
    private List<Categoria> categorias = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();

    /**
     * Creates a new instance of ProductosBean
     */
    public ProductosBean() {
    }

    @PostConstruct
    public void init() {
        this.categorias = this.categoriasDAO.getCategorias();
        this.productos = this.productosDAO.getProductos();
        this.btnAccion = "Crear";
    }

    public String getImagen(Producto producto) {
        try {
            return "data:image/*;base64," + Base64.getEncoder().encodeToString(producto.getFotoProducto());
        } catch (Exception ex) {
            return "";
        }
    }

    public void crearProducto() {
        try {
            Producto producto = new Producto();
            producto.setNombreProducto(nombre);
            producto.setPrecioProducto(precio);
            producto.setUnidadesProducto(unidades);
            producto.setDescripcionProducto(descripcion);

            Categoria categoria = this.categoriasDAO.obtener(this.idCategoriaSeleccionada);
            producto.setCategoria(categoria);
            if (this.archivo != null) {
                producto.setFotoProducto(IOUtils.toByteArray(archivo.getInputStream()));
            }
            this.productosDAO.persist(producto);
            this.mensaje = "Producto Creado";
            this.productos = this.productosDAO.getProductos();
        } catch (Exception ex) {
            this.mensaje = "Error: " + ex.getMessage();
        }

    }

    private void actualizarProducto() {
        try {
            this.productoEditado
                    .setCategoria(this.categoriasDAO.obtener(this.idCategoriaSeleccionada));
            this.productoEditado.setNombreProducto(nombre);
            this.productoEditado.setDescripcionProducto(descripcion);
            this.productoEditado.setPrecioProducto(precio);
            this.productoEditado.setUnidadesProducto(unidades);
            if (this.archivo != null) {
                this.productoEditado.setFotoProducto(IOUtils.toByteArray(archivo.getInputStream()));
            }
            this.productosDAO.merge(productoEditado);
            this.mensaje = "Producto Actualizado";
        } catch (Exception ex) {
            this.mensaje = "Error: " + ex.getMessage();
        }
    }

    public void actuar() {
        if (this.btnAccion.equals("Crear")) {
            this.crearProducto();
        } else {
            this.actualizarProducto();
        }
    }

    public void limpiarForm() {
        this.mensaje = "";
        this.btnAccion = "Crear";
        this.nombre = "";
        this.precio = 0;
        this.unidades = 0;
        this.descripcion = "";
        this.idCategoriaSeleccionada = null;
    }

    public void editar(Producto producto) {
        if (producto.getCategoria() != null) {
            this.idCategoriaSeleccionada = producto.getCategoria().getIdCategoria();
        }
        this.nombre = producto.getNombreProducto();
        this.descripcion = producto.getDescripcionProducto();
        this.unidades = producto.getUnidadesProducto();
        this.precio = producto.getPrecioProducto();
        this.productoEditado = producto;
        this.mensaje = "";
        this.archivo = null;
        this.btnAccion = "Actualizar";
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBtnAccion() {
        return btnAccion;
    }

    public void setBtnAccion(String btnAccion) {
        this.btnAccion = btnAccion;
    }

    public Producto getProductoEditado() {
        return productoEditado;
    }

    public void setProductoEditado(Producto productoEditado) {
        this.productoEditado = productoEditado;
    }

    public Categoria getCategoriaSeleccionada() {
        return categoriaSeleccionada;
    }

    public void setCategoriaSeleccionada(Categoria categoriaSeleccionada) {
        this.categoriaSeleccionada = categoriaSeleccionada;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Integer getIdCategoriaSeleccionada() {
        return idCategoriaSeleccionada;
    }

    public void setIdCategoriaSeleccionada(Integer idCategoriaSeleccionada) {
        this.idCategoriaSeleccionada = idCategoriaSeleccionada;
    }

    public Part getArchivo() {
        return archivo;
    }

    public void setArchivo(Part archivo) {
        this.archivo = archivo;
    }

}
