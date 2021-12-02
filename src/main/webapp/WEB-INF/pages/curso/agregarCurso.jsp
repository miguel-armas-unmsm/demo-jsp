<div class="modal fade" id="agregarCursoModal">
        <div class="modal-dialog modal-lg">
        
        <!-- inicio: MODAL-CONTENEDOR -->
        <div class="modal-content">
            
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar curso</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>  <!-- fin: MODAL-HEADER -->
            
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertarCurso"
                  method="POST" class="was-validated">
            
                <div class="modal-body">
                   
                    <div class="form-group">
                        <label for="codigo">Código</label>
                        <input type="text" class="form-control" name="codigo" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="creditos">Créditos</label>
                        <input type="number" class="form-control" name="creditos" required>
                    </div>
                    
                </div>  <!-- fin: MODAL-BODY -->
            
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>  <!-- fin: MODAL-FOOTER -->
            
            </form> <!-- fin: FORMULARIO -->
        </div>  <!-- fin: MODAL-CONTENEDOR -->
    </div>  <!-- fin: MODAL-DIALOGO -->
</div>  <!-- fin: MODAL -->