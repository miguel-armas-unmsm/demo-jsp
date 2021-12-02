<!-- importo la librería core de jstl-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- importo la librería para dar formato a las cadenas -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!-- indico la localidad -->
<fmt:setLocale value="es_MX"></fmt:setLocale>

<div class="modal fade" id="obtenerDetalleModal">

    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Detalle</h5>

                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <div class="modal-body">

                <c:forEach var="det" items="${detalles}" varStatus="status">
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>Codigo</th>
                                <th>Nombres</th>
                                <th>Nota</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr>
                                <td>${det.codigo}</td>
                                <td>${det.nombreCurso}</td>
                                <td>${det.nota}</td>
                            </tr>
                        </tbody>    <!-- fin: CUERPO-TABLA -->  
                    </table>    <!-- fin: TABLA -->
                </c:forEach>
            </div>
        </div>  <!-- fin: MODAL-CONTENEDOR -->
    </div>  <!-- fin: MODAL-DIALOGO -->
</div>  <!-- fin: MODAL -->