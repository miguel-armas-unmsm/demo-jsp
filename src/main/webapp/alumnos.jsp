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
        
        <title>Control de alumnos</title>
    </head>
    <body>
        <!-- cabecero -->
        <jsp:include page="/WEB-INF/pages/comunes/cabecero.jsp"></jsp:include>
        
        <!-- botones de navegación -->
        <jsp:include page="/WEB-INF/pages/comunes/botonesNavegacion.jsp"></jsp:include>
        
        <!-- listado de alumnos -->
        <jsp:include page="/WEB-INF/pages/alumno/listadoAlumno.jsp"></jsp:include>
        
        <jsp:include page="/WEB-INF/pages/comunes/botonesNavegacionCurso.jsp"></jsp:include>
        <jsp:include page="/WEB-INF/pages/curso/listadoCurso.jsp"></jsp:include>
        
        <!-- pie de página-->
        <jsp:include page="/WEB-INF/pages/comunes/piePagina.jsp"></jsp:include>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

    </body>
</html>
