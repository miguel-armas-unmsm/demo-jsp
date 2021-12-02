<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/6edb988eb9.js" crossorigin="anonymous"></script>

        <title>Editar cliente</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/pages/comunes/cabecero.jsp"></jsp:include>

        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificarCurso&codCurso=${curso.codigo}"
          method="POST" class="was-validated">

            <!-- botones de navegación de edicion -->
            <jsp:include page="/WEB-INF/pages/comunes/botonesNavegacionEdicion.jsp"></jsp:include>

            <sectionl id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                
                                <!-- cabecero de tarjeta --> 
                                <div class="card-header">
                                    <h4>Editar curso</h4>
                                </div>
                                
                                <!-- cuerpo de tarjeta -->
                                 <div class="form-group">
                                     <label for="nombre">Nombre</label>
                                     <input type="text" class="form-control" name="nombre" required value="${curso.nombre}">
                                 </div>

                                 <div class="form-group">
                                     <label for="creditos">Créditos</label>
                                     <input type="number" class="form-control" name="creditos" required value="${curso.creditos}">
                                 </div>

                            </div>
                        </div>
                    </div>
                </div>
            </sectionl>
        </form>
        <!-- fin: FORMULARIO -->
                
        <!-- pie de página-->
        <jsp:include page="/WEB-INF/pages/comunes/piePagina.jsp"></jsp:include>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

    </body>
</html>
