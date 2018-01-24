
<%@include  file="templates/header.jsp" %>
    <c:if test="${requestScope.msg != null}">
        <div class="row">
            <div class=" red darken-4 white-text">
                ${requestScope.msg}
            </div>
        </div>
    </c:if>
    <form class="row form" method="POST" action="procesar4.do">
        <div class="col s12 l6 m8 offset-l4 offset-m2">
            <div class="row">
                <h3>Ejercicio con Sesiones</h3>
            </div>
            <div class="row">
                <div class="input-field col s12 l12 m12">
                    <label for="nombre">Nombre</label>
                    <input placeholder="Nombre" value="${cookie.username.value}" type="text" name="nombre" class="validate"  />
                </div>
            </div>

            <div class="row">
                <div class="input-field col s12 l12 m12">
                    <label for="clave">Clave</label>
                    <input placeholder="Clave" type="password" name="clave" class="validate"  />
                </div>
            </div>

            <div class="row">
                <div class="input-field col s12 l12 m12">
                    <input type="submit" class="btn waves-light waves-effect red darken-4" value="Iniciar Sesión" />
                </div>
            </div>
        </div>
    </form>



   <%@include file="templates/footer.jsp" %>