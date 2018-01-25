<%-- 
    Document   : index
    Created on : Jan 24, 2018, 3:43:16 PM
    Author     : sarayar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="cl.inacap.ejercicioJPA.model.Producto"%>
<%@page import="java.util.List"%>
<%@page import="cl.inacap.ejercicioJPA.beans.ServicioBeanLocal"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! private ServicioBeanLocal service;%>
        <% InitialContext ctx = new InitialContext();
            service = (ServicioBeanLocal) ctx.lookup("java:global/EjercicioJPA/ServicioBean!cl.inacap.ejercicioJPA.beans.ServicioBeanLocal");
            List<Producto> productos = service.getProductos();
        %>
        <c:set var="productos" scope="page" value="<%=productos%>"></c:set>
            <table>
                <tr>
                    <th>Nombre</th>
                    <th>Categoria</th>
                </tr>
            <c:forEach items="${pageScope.productos}" var="producto">
                <tr>
                    <td>${producto.nombreProducto}</td>
                    <td>${producto.categoria.nombreCategoria}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
