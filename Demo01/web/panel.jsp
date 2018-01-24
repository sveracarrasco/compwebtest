<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%@include  file="templates/header.jsp" %>
    <c:if test="${not empty sessionScope.persona}">
    <nav class="blue darken-5">
        <div class="nav-wrapper container">
            <a href="#" class="brand-logo">Logo</a>

            <ul class="right">
                <li>Bienvenido ${sessionScope.persona}</li>
            </ul>

        </div>
    </nav>
    </c:if>
    <c:if test="${empty sessionScope.persona}">
        <div class="green darken-4">
            <h3 class="white-text">Debe Iniciar Sesión</h3>

            <a href="demo4.jsp" class="btn blue lighten-3 waves-light waves-effect ">Ir a Login</a>
        </div>
    </c:if>
    <%@include file="templates/footer.jsp" %>
