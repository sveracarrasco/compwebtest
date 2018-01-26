package cl.inacap.mascotas.model;

import cl.inacap.mascotas.model.Detalleventa;
import cl.inacap.mascotas.model.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-26T10:29:50")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile ListAttribute<Venta, Detalleventa> detalleventaList;
    public static volatile SingularAttribute<Venta, Integer> totalVenta;
    public static volatile SingularAttribute<Venta, Usuario> usuario;
    public static volatile SingularAttribute<Venta, Integer> idVenta;
    public static volatile SingularAttribute<Venta, Date> fechaVenta;

}