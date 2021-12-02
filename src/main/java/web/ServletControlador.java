package web;

import repository.AlumnoDao;
import models.Alumno;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import models.Curso;
import models.Detalle;
import repository.CursoDao;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    /**
     * Manejo de la página de inicio, default
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editarAlumno":
                    this.editarAlumno(request, response);
                    break;

                case "eliminarAlumno":
                    this.eliminarAlumno(request, response);
                    break;

                case "obtenerDetalle":
                    this.obtenerDetalle(request, response);
                    break;
                    
                case "editarCurso":
                    this.editarCurso(request, response);
                    break;
                    
                case "eliminarCurso":
                    this.eliminarCurso(request, response);
                    break;
                    
                default:
                    //no se proporcionó un valor válido
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);  
        }
    }

    private void obtenerDetalle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String codAlumno = request.getParameter("codAlumnoDetalle");
        List<Detalle> detalles = new AlumnoDao().obtenerDetalle(codAlumno);
        request.setAttribute("detalles", detalles);
        String jspDetalle = "/WEB-INF/pages/alumno/obtenerDetalle.jsp";
        request.getRequestDispatcher(jspDetalle).forward(request, response);

    }
    
    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        //recupero la lista de alumnos de la BD
        List<Alumno> alumnos = new AlumnoDao().listar();
        for (Alumno a : alumnos) {
            System.out.println(a);
        }

        List<Curso> cursos = new CursoDao().listar();
      
        //recupero la session
        HttpSession sesion = request.getSession();

        //seteo el atributo alumnos en el alcance session
        sesion.setAttribute("alumnos", alumnos);
        sesion.setAttribute("cursos", cursos);
        
        //seteo el atributo totalAlumnos en el alcante session
        sesion.setAttribute("totalAlumnos", alumnos.size());

        /*
        request.getRequestDispatcher("alumnos.jsp").forward(request, response);
        
        Nota: forward
        Este método permanece con la información del alcance request, de forma que,
        al redireccionar la página, se vuelve a ejecutar la misma acción. Para evitar
        esto, utilizaremos el alcance session en lugar de request y redireccionaremos
        mediante .sendRedirect
         */
        response.sendRedirect("alumnos.jsp");
    }

    /**
     * Recupera el codAlumno
     */
    private void editarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recupero el codAlumno
        String codAlumno = request.getParameter("codAlumno");

        //recupero el objeto alumno de la BD a partir del codAlumno
        Alumno alumno = new AlumnoDao().encontrar(new Alumno(codAlumno));

        //envío el objeto alumno al alcance request
        request.setAttribute("alumno", alumno);

        String jspEditar = "/WEB-INF/pages/alumno/editarAlumno.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

    }

    /**
     * Manejo del formulario en la ventana MODAL
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertarAlumno":
                    this.insertarAlumno(request, response);
                    break;

                case "modificarAlumno":
                    this.modificarAlumno(request, response);
                    break;

                case "insertarCurso":
                    this.insertarCurso(request, response);
                    break;

                case "modificarCurso":
                    this.modificarCurso(request, response);
                    break;
                    
                default:
                    //no se proporcionó un valor válido
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recupero valores del formulario agregarAlumno
        String codAlumno = request.getParameter("codAlumno");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");        

        //creo el objeto modelo alumno
        Alumno alumno = new Alumno(codAlumno, nombre, apellido);

        //inserto el nuevo objeto en la BD
        int registrosModificados = new AlumnoDao().insertar(alumno);
        this.accionDefault(request, response);
    }

    private void modificarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
        el parámetro codAlumno no es visible en el formulario, sino que ha sido enviado
        como parámetro POST.
         */
        String codAlumno = request.getParameter("codAlumno");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");

        //creo el objeto modelo alumno
        Alumno alumno = new Alumno(codAlumno, nombre, apellido);

        //modifico el objeto en la BD
        int registrosModificados = new AlumnoDao().actualizar(alumno);
        this.accionDefault(request, response);
    }

    private void eliminarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
        el parámetro codAlumno no es visible en el formulario, sino que ha sido enviado
        como parámetro POST.
         */
        String codAlumno = request.getParameter("codAlumno");

        //creo el objeto modelo alumno
        Alumno alumno = new Alumno(codAlumno);

        //modifico el objeto en la BD
        int registrosModificados = new AlumnoDao().eliminar(alumno);
        this.accionDefault(request, response);
    }
    
    private void eliminarCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codCurso = request.getParameter("codCurso");
        Curso curso = new Curso(codCurso);
        int registrosModificados = new CursoDao().eliminar(curso);
        this.accionDefault(request, response);
    }
    
    private void editarCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codCurso = request.getParameter("codCurso");
        Curso curso = new CursoDao().encontrar(new Curso(codCurso));
        request.setAttribute("curso", curso);
        String jspEditar = "/WEB-INF/pages/curso/editarCurso.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    private void insertarCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String creditosString = request.getParameter("creditos");
        
        int creditos = 0;
        if (creditosString != null && !"".equals(creditosString)) {
            creditos = Integer.parseInt(creditosString);
        }

        Curso curso = new Curso(codigo, nombre, creditos);

        int registrosModificados = new CursoDao().insertar(curso);
        this.accionDefault(request, response);
    }

    private void modificarCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codCurso = request.getParameter("codCurso");

        String nombre = request.getParameter("nombre");
        int creditos = 0;
        String creditosString = request.getParameter("creditos");
        if (creditosString != null && !"".equals(creditosString)) {
            creditos = Integer.parseInt(creditosString);
        }

        Curso curso = new Curso(codCurso, nombre, creditos);
        int registrosModificados = new CursoDao().actualizar(curso);
        this.accionDefault(request, response);
    }
    
}
