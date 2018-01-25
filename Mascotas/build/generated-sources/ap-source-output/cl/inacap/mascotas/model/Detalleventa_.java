package cl.inacap.mascotas.model;

import cl.inacap.mascotas.model.Producto;
import cl.inacap.mascotas.model.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-25T16:45:51")
@StaticMetamodel(Detalleventa.class)
public class Detalleventa_ { 

    public static volatile SingularAttribute<Detalleventa, Integer> precio;
    public static volatile SingularAttribute<Detalleventa, Venta> venta;
    public static volatile SingularAttribute<Detalleventa, Integer> idDetalleVenta;
    public static volatile SingularAttribute<Detalleventa, Producto> producto;

}