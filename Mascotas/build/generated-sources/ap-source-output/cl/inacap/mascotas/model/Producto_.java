package cl.inacap.mascotas.model;

import cl.inacap.mascotas.model.Categoria;
import cl.inacap.mascotas.model.Detalleventa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-25T16:45:51")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile ListAttribute<Producto, Detalleventa> detalleventaList;
    public static volatile SingularAttribute<Producto, String> descripcionProducto;
    public static volatile SingularAttribute<Producto, Categoria> categoria;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile SingularAttribute<Producto, Integer> precioProducto;
    public static volatile SingularAttribute<Producto, Integer> unidadesProducto;
    public static volatile SingularAttribute<Producto, byte[]> fotoProducto;
    public static volatile SingularAttribute<Producto, String> nombreProducto;

}