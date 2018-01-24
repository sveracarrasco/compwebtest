<%@include  file="templates/header.jsp" %>
    <c:if test="${requestScope.msg != null}">
        <div class="row">
            <div class=" red darken-4 white-text">
                ${requestScope.msg}
            </div>
        </div>
    </c:if>
    <form class="row form" method="POST" action="procesar2.do">
        <div class="col s12 l6 m8 offset-l4 offset-m2">
            <div class="row">
                <h3>Ejercicio con ContextListener</h3>
            </div>
            <div class="row">
                <div class="input-field col s12 l12 m12">
                    <label for="nombre">Nombre</label>
                    <input placeholder="Nombre" type="text" name="nombre" class="validate"  />
                </div>
            </div>

            <div class="row">
                <div class="input-field col s12 l12 m12">
                    <label for="edad">Edad</label>
                    <input placeholder="Edad" type="number" name="edad" class="validate"  />
                </div>
            </div>

            <div class="row">
                <div class="input-field col s12 l12 m12">
                    <input type="submit" class="btn waves-light waves-effect blue darken-4" value="Ingresar" />
                </div>
            </div>
        </div>
    </form>
    <div class="row">
        <table class="striped">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Edad</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${applicationScope.data}" var="persona">
                <tr>
                    <td>${persona.nombre}</td>
                    <td>${persona.edad}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

<%@include file="templates/footer.jsp" %>