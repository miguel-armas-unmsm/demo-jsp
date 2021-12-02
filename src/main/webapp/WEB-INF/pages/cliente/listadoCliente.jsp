<!-- importo la librería core de jstl-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- importo la librería para dar formato a las cadenas -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!-- indico la localidad -->
<fmt:setLocale value="es_MX"></fmt:setLocale>

<section id="clientes">
    
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
                        <h4>Listado de clientes</h4> 
                    </div>  <!-- fin: CABECERO-TARJETA -->

                    <!-- inicio: TABLA -->
                    <table class="table table-striped"> <!-- tabla a rayas (color intercalado) -->
                        
                        <!-- inicio: CABECERO-TABLA -->
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Saldo</th>
                                <th></th>
                            </tr>
                        </thead> <!-- fin: CABECERO-TABLA -->
                        
                        <!-- inicio: CUERPO-TABLA -->
                        <tbody>
                            <c:forEach var="cliente" items="${clientes}" varStatus="status">
                                <!-- recorro el objeto clientes pasado como parámetro -->
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${cliente.nombre} ${cliente.apellido}</td>
                                    <td>${cliente.saldo}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idCliente=${cliente.idCliente}"
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

            <!-- inicio: 12/12 COLUMNAS -->
            <div class="col-md-3">
                
                <!-- inicio: TARJETA -->
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Saldo total</h3>
                        <h4 class="display-4">${saldoTotal}</h4>
                    </div>
                </div> <!-- fin: TARJETA -->

                <!-- inicio: TARJETA -->
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total clientes</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalClientes}
                        </h4>
                    </div>
                </div> <!-- fin: TARJETA -->
                
            </div> <!-- fin: 12/12 COLUMNAS -->

        </div>  <!-- fin: FILA -->
        
    </div>  <!-- fin: CONTAINER -->
    
</section>
                        
<!-- Agregar cliente MODAL -->
<jsp:include page="/WEB-INF/pages/cliente/agregarCliente.jsp"/>