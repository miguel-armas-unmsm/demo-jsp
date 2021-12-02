<!-- importo la librería core de jstl-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- importo la librería para dar formato a las cadenas -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!-- indico la localidad -->
<fmt:setLocale value="es_MX"></fmt:setLocale>

<section id="alumnos">
    
    <!--  inicio: CONTAINER -->
    <div class="container">
        
        <!-- inicio: FILA -->
        <div class="row">
            
            <!-- inicio: 9/12-COLUMNAS -->
            <div class="col-md-9">
                
                <!-- inicio: TARJETA  -->
                <div class="card">
                    
                    <!-- inicio: CABECERO-TARJETA -->
                    <div class="card-header">
                        <h4>Listado de alumnos</h4> 
                    </div>  <!-- fin: CABECERO-TARJETA -->

                    <!-- inicio: TABLA -->
                    <table class="table table-striped"> <!-- tabla a rayas (color intercalado) -->
                        
                        <!-- inicio: CABECERO-TABLA -->
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombres</th>
                                <th>Apellidos</th>
                                <th></th>
                            </tr>
                        </thead> <!-- fin: CABECERO-TABLA -->
                        
                        <!-- inicio: CUERPO-TABLA -->
                        <tbody>
                            <c:forEach var="alumno" items="${alumnos}" varStatus="status">
                                <!-- recorro el objeto alumnos pasado como parámetro -->
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${alumno.nombre}</td>    
                                    <td>${alumno.apellido}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&codAlumno=${alumno.codAlumno}"
                                            class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>    <!-- fin: CUERPO-TABLA -->  
                        
                    </table>    <!-- fin: TABLA -->
                    
                </div>  <!-- fin: TARJETA -->
                
            </div>  <!-- fin: 9/12 COLUMNAS -->            

        </div>  <!-- fin: FILA -->
        
    </div>  <!-- fin: CONTAINER -->
    
</section>
                        
<!-- Agregar alumno MODAL -->
<jsp:include page="/WEB-INF/pages/alumno/agregarAlumno.jsp"/>