package cl.inacap.mascotas.model;

import cl.inacap.mascotas.model.Historial;
import cl.inacap.mascotas.model.Perfil;
import cl.inacap.mascotas.model.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-26T10:29:51")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> clave;
    public static volatile SingularAttribute<Usuario, String> rutUser;
    public static volatile SingularAttribute<Usuario, String> emailUser;
    public static volatile SingularAttribute<Usuario, String> apellidoUser;
    public static volatile ListAttribute<Usuario, Venta> ventaList;
    public static volatile SingularAttribute<Usuario, String> nombreUser;
    public static volatile ListAttribute<Usuario, Historial> historialList;
    public static volatile SingularAttribute<Usuario, Perfil> perfil;

}