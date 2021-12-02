<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

        <!-- Font Awesome -->
        <script src="https://kit.fontawesome.com/6edb988eb9.js" crossorigin="anonymous"></script>

        <title>Editar cliente</title>
    </head>
    <body>
        <!-- cabecero -->
        <jsp:include page="/WEB-INF/pages/comunes/cabecero.jsp"></jsp:include>

        <!-- inicio: FORMULARIO -->
        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${cliente.idCliente}"
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
                                    <h4>Editar cliente</h4>
                                </div>
                                
                                <!-- cuerpo de tarjeta -->
                                <!-- nombre -->
                                 <div class="form-group">
                                     <label for="nombre">Nombre</label>
                                     <input type="text" class="form-control" name="nombre" required value="${cliente.nombre}">
                                 </div>

                                 <!-- apellido -->
                                 <div class="form-group">
                                     <label for="apellido">Apellido</label>
                                     <input type="text" class="form-control" name="apellido" required value="${cliente.apellido}">
                                 </div>

                                 <!-- email -->
                                 <div class="form-group">
                                     <label for="email">Email</label>
                                     <input type="email" class="form-control" name="email" required value="${cliente.email}">
                                 </div>

                                 <!-- telefono -->
                                 <div class="form-group">
                                     <label for="telefono">Telefono</label>
                                     <input type="tel" class="form-control" name="telefono" required value="${cliente.telefono}">
                                 </div>

                                 <!-- saldo -->
                                 <div class="form-group">
                                     <label for="saldo">Saldo</label>
                                     <input type="number" class="form-control" name="saldo" required value="${cliente.saldo}" step="any"> <!-- step="any" acepta valores decimales -->
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
