<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="templates/header.jsp" %>

<c:if test="${not empty requestScope.errores}">
    <div class="row">
        <div class="s12 l6 offset-l3 m8 offset-m2 red darken-3 white-text">
            <ul>
                <c:forEach items="${requestScope.errores}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
</c:if>
<div class="row">
    <div class="col s12 l6 offset-l3 m8 offset-m2 ">
        <form method="POST" action="controller.do">
            <div class="row">
                <div class="input-field col s6">
                    <input placeholder="Rut" name="rut" type="text" class="validate">
                    <label for="rut">Rut</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <input placeholder="Password" name="clave" type="password" class="validate">
                    <label for="clave">Clave</label>
                </div>
            </div>
            <div class="row">
                <button type="submit" 
                        name="accion" value="loguear" 
                        class="btn waves-effect waves-button-input blue lighten-3" >
                    Iniciar Sesión</button> 
            </div>

        </form>
    </div>  

</div>

<%@include file="templates/footer.jsp" %>