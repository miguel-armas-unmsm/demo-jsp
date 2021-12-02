<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- importo la librería para dar formato a las cadenas -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

        <script src="https://kit.fontawesome.com/6edb988eb9.js" crossorigin="anonymous"></script>

        <title>Detalle</title>
    </head>
    <body>

        <div class="row">
            <div class="col-md-3">
                <a href="index.jsp" class="btn btn-ligth btn-block">
                    <i class="fas fa-arrow-left"></i> Regresar al inicio
                </a>
            </div>
        </div>

        <div  class ="col-md-3">

            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>Codigo</th>
                        <th>Nombres</th>
                        <th>Nota</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="detalle" items="${detalles}" varStatus="status">
                        <tr>
                            <td>${detalle.codigo}</td>
                            <td>${detalle.nombreCurso}</td>
                            <td>${detalle.nota}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>


        </div>

        <!-- pie de página-->
        <jsp:include page="/WEB-INF/pages/comunes/piePagina.jsp"></jsp:include>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

    </body>
</html>
