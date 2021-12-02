<div class="modal fade" id="obtenerDetalleModal">

    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Detalle</h5>

                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <div class="modal-body edit-content">

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
            </div>
        </div>  <!-- fin: MODAL-CONTENEDOR -->
    </div>  <!-- fin: MODAL-DIALOGO -->
</div>  <!-- fin: MODAL -->