
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- librería core de jstl-->
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %> <!-- dar formato a las cadenas -->
<fmt:setLocale value="es_MX"></fmt:setLocale> <!-- localidad -->

<section id="cursos">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de cursos</h4> 
                    </div>

                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Créditos</th>
                                <th></th>
                            </tr>
                        </thead>
                        
                        <tbody>
                            <c:forEach var="curso" items="${cursos}" varStatus="status">
                                <!-- recorro el objeto clientes pasado como parámetro -->
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${curso.nombre}</td>
                                    <td>${curso.creditos}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editarCurso&codCurso=${curso.codigo}"
                                            class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table> 
                </div>  <!-- fin: TARJETA -->
            </div> 
        </div>
    </div>
</section>
                        
<jsp:include page="/WEB-INF/pages/curso/agregarCurso.jsp"/>