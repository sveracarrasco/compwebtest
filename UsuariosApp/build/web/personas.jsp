<%@page import="javax.naming.InitialContext"%>
<%@page import="cl.inacap.usuariosApp.beans.PersonaBeanLocal"%>
<%@include file="templates/header.jsp" %>
<div class="row">
    <c:if test="${sessionScope.usuario.perfil.equals('Admin') }">
        <div class="col s6 offsset-s3 m8 offset-m4 l10 offset-l1 z-depth-3">
            <h4 class="center-align"> Personas existentes</h4>
            <form method="POST" action="controller.do">
                <table class="bordered striped">
                    <thead>
                        <tr>
                            <th>Rut</th>
                            <th>Nombre</th>
                            <th>Mail</th>
                            <th>Perfil</th>
                            <th>Activo</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%! private PersonaBeanLocal service; %>
                        <%
                            InitialContext ctx = new InitialContext();
                            service = (PersonaBeanLocal) ctx.lookup("java:global/UsuariosApp/PersonaBean!cl.inacap.usuariosApp.beans.PersonaBeanLocal");
                            
                            %>
                            <c:set scope="page" var="personas" value="<%=service.getPersonaList()%>" ></c:set>    
                            <c:forEach items="${pageScope.personas}" var="persona">
                            <tr>
                                <td>${persona.rut}</td>
                                <td>${persona.nombre}</td>
                                <td>${persona.mail}</td>
                                <td>${persona.perfil}</td>
                                <td>${persona.activo? "Si": "No"}</td>
                                <td><button name="editar" type="submit" value="${persona.rut}"
                                            class="btn waves-light waves-effect">Editar</button></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
    </c:if> 
    <c:if test="${!sessionScope.usuario.perfil.equals('Admin')}">
        <div class="col l12 s12 m12 red darken-5">
            No tienes permisos para estar aqu�
            <a href="index.jsp">Vayase de aqu�!</a>
        </div>
    </c:if>
</div>
<%@include file="templates/footer.jsp" %>