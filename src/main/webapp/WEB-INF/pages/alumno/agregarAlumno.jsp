<!-- inicio: MODAL -->
<div class="modal fade" id="agregarAlumnoModal">
    
    <!-- inicio: MODAL-DIALOGO -->
    <div class="modal-dialog modal-lg">
        
        <!-- inicio: MODAL-CONTENEDOR -->
        <div class="modal-content">
            
            <!-- inicio: MODAL-HEADER -->
            <div class="modal-header bg-info text-white">
                <!-- titulo -->
                <h5 class="modal-title">Agregar alumno</h5>
                
                <!-- boton-close -->
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>  <!-- fin: MODAL-HEADER -->
            
            <!-- inicio: FORMULARIO -->
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertarAlumno"
                  method="POST" class="was-validated">
            
                <!-- inicio: MODAL-BODY -->
                <div class="modal-body">
                    
                    <!-- nombre -->
                    <div class="form-group">
                        <label for="codAlumno">Codigo</label>
                        <input type="text" class="form-control" name="codAlumno" required>
                    </div>
                    
                    <!-- nombre -->
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    
                    <!-- apellido -->
                    <div class="form-group">
                        <label for="apellido">Apellido</label>
                        <input type="text" class="form-control" name="apellido" required>
                    </div>                                        
                </div>  <!-- fin: MODAL-BODY -->
            
                <!-- inicio: MODAL-FOOTER -->
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>  <!-- fin: MODAL-FOOTER -->
            
            </form> <!-- fin: FORMULARIO -->
        </div>  <!-- fin: MODAL-CONTENEDOR -->
    </div>  <!-- fin: MODAL-DIALOGO -->
</div>  <!-- fin: MODAL -->