<section id="actions" class="py-4 mb-4 bg-light">

    <!-- inicio: CONTAINER -->
    <div class="container">

        <!-- inicio: FILA -->
        <div class="row">

            <!-- inicio: 3/12-COLUMNAS -->
            <div class="col-md-3">

                <!-- boton regresar -->
                <a href="index.jsp" class="btn btn-ligth btn-block">
                    <i class="fas fa-arrow-left"></i> Regresar al inicio
                </a>
            </div>  <!-- fin: 3/12-COLUMNAS -->

            <!-- inicio: 6/12-COLUMNAS -->
            <div class="col-md-3">

                <!-- boton guardar-alumno -->
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Guardar alumno
                </button>
            </div>  <!-- fin: 6/12-COLUMNAS -->
            
            <!-- inicio: 9/12-COLUMNAS --->
            <div class="col-md-3">
                
                <!-- boton eliminar-alumno -->
                <!-- ejecución a través de un link, doGet -->
                <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminarAlumno&codAlumno=${alumno.codAlumno}"
                   class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i> Eliminar alumno
                </a>
            </div>
            
        </div>  <!-- fin: FILA -->
    </div>  <!-- fin: CONTAINER -->
</section>