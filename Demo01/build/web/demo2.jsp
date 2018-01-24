<%@include  file="templates/header.jsp" %>
              <div class="row">
                  <c:if test="${requestScope != null && requestScope.msg != null}" >
                    <div class="col s12 l12 m12">
                        <h3 class="red darken-4 white-text text-darken-2 ">${requestScope.msg}</h3>
                    </div>
                  </c:if>
                    <form method="POST" action="procesa.do"  class="col s12 m7 offset-m3 l6 offset-l4">
                        <div class="row">
                            <div class="col s6 l6 m6" >
                                 <h3>Demo 2 Form</h3>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6 l6 m6">
                                <input placeholder="Nombre" type="text" name="nombre" class="validate" />
                                <label for="nombre">Nombre</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12 l12 m12">
                                <select name="perfil">
                                    <option value="Alumno">Alumno</option>
                                    <option value="Docente">Docente</option>
                                    <option value="Admin">Admin</option>
                                </select>
                                <label for="perfil">Perfil</label>
                            </div>
                            
                        </div>
                        <div class="row">
                             <div class="input-field col s6 l6 m6">
                                <button type="submit" name="bt" class="btn waves-effect waves-light" >Enviar</button>
                             </div>
                        </div>
                    </form>
              </div>

<%@include file="templates/footer.jsp" %>