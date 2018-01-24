<%@include file="templates/header.jsp" %>
<div class="row">
    <c:if test="${sessionScope.usuario.perfil.equals('Admin') }">
        <div class="col s12 l6 offset-l3 m8 offset-m2 ">
            <form method="POST" action="controller.do">
                <div class="row">
                    <div class="input-field col s6">
                        <input placeholder="Rut" readonly name="rut" value="${requestScope.persona.rut}" type="text" class="validate">
                        <label for="rut">Rut</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <input placeholder="Nombre" value="${requestScope.persona.nombre}" name="nombre" type="text" class="validate">
                        <label for="nombre">Nombre</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <i class="material-icons prefix">mail</i>
                        <input type="email" value="${requestScope.persona.mail}" name="correo"  class="validate"/>
                        <label for="correo">Correo</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <select name="perfil">
                            <option ${requestScope.persona.perfil.equals("Admin")? "selected": ''}
                                value="Admin">Admin</option>
                            <option
                                ${requestScope.persona.perfil.equals("Alumno")? "selected": ''}
                                value="Alumno">Alumno</option>
                        </select>
                        <label for="perfil">Perfil</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col s6">
                        <label for="activo">Activo</label>
                        <div class="switch">
                            <label>
                                No
                                <input name="activo" value="1" ${requestScope.persona.activo? "checked": ''} type="checkbox">
                                <span class="lever"></span>
                                Sí
                            </label>

                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <input placeholder="Password" value="${requestScope.persona.clave}" name="clave" type="password" class="validate">
                        <label for="clave">Clave</label>
                    </div>
                    <div class="input-field col s6">
                        <input placeholder="Repita Password" value="${requestScope.persona.clave}" name="claveRep" type="password" class="validate">
                        <label for="claveRep">Repita Clave</label>
                    </div>
                </div>
                <div class="row">
                    <button type="submit" 
                            name="accion" value="actualizar" 
                            class="btn waves-effect waves-button-input orange darken-3" >
                        Actualizar</button> 
                </div>

            </form>
        </div>
    </c:if> 
    <c:if test="${!sessionScope.usuario.perfil.equals('Admin')}">
        <div class="col l12 s12 m12 red darken-5">
            No tienes permisos para estar aquí
            <a href="index.jsp">Vayase de aquí!</a>
        </div>
    </c:if>
</div>
<%@include file="templates/footer.jsp" %>