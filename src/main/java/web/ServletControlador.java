package web;

import capa_datos.ClienteDaoJdbc;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

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
                case "editar":
                    this.editarCliente(request, response);
                    break;

                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;

                default:
                    //no se proporcionó un valor válido
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);  
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recupero la lista de clientes de la BD
        List<Cliente> clientes = new ClienteDaoJdbc().listar();
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        //recupero la session
        HttpSession sesion = request.getSession();

        //seteo el atributo clientes en el alcance session
        sesion.setAttribute("clientes", clientes);

        //seteo el atributo totalClientes en el alcante session
        sesion.setAttribute("totalClientes", clientes.size());

        //seteo el atributo saldoTotal en el alcance session
        sesion.setAttribute("saldoTotal", calcularSaldoTotal(clientes));

        /*
        request.getRequestDispatcher("clientes.jsp").forward(request, response);
        
        Nota: forward
        Este método permanece con la información del alcance request, de forma que,
        al redireccionar la página, se vuelve a ejecutar la misma acción. Para evitar
        esto, utilizaremos el alcance session en lugar de request y redireccionaremos
        mediante .sendRedirect
         */
        response.sendRedirect("clientes.jsp");
    }

    private double calcularSaldoTotal(List<Cliente> clientes) {

        double total = 0;
        for (Cliente c : clientes) {
            total += c.getSaldo();
        }
        return total;
    }

    /**
     * Recupera el idCliente
     */
    private void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recupero el idCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        //recupero el objeto cliente de la BD a partir del idCliente
        Cliente cliente = new ClienteDaoJdbc().encontrar(new Cliente(idCliente));

        //envío el objeto cliente al alcance request
        request.setAttribute("cliente", cliente);

        String jspEditar = "/WEB-INF/pages/cliente/editarCliente.jsp";
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
                case "insertar":
                    this.insertarCliente(request, response);
                    break;

                case "modificar":
                    this.modificarCliente(request, response);
                    break;

                default:
                    //no se proporcionó un valor válido
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recupero valores del formulario agregarCliente
        String nombre = request.getParameter("nombre");
        String apeliido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }

        //creo el objeto modelo cliente
        Cliente cliente = new Cliente(nombre, apeliido, email, telefono, saldo);

        //inserto el nuevo objeto en la BD
        int registrosModificados = new ClienteDaoJdbc().insertar(cliente);
        this.accionDefault(request, response);
    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
        el parámetro idCliente no es visible en el formulario, sino que ha sido enviado
        como parámetro POST.
         */
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        String nombre = request.getParameter("nombre");
        String apeliido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }

        //creo el objeto modelo cliente
        Cliente cliente = new Cliente(idCliente, nombre, apeliido, email, telefono, saldo);

        //modifico el objeto en la BD
        int registrosModificados = new ClienteDaoJdbc().actualizar(cliente);
        this.accionDefault(request, response);
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
        el parámetro idCliente no es visible en el formulario, sino que ha sido enviado
        como parámetro POST.
         */
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        //creo el objeto modelo cliente
        Cliente cliente = new Cliente(idCliente);

        //modifico el objeto en la BD
        int registrosModificados = new ClienteDaoJdbc().eliminar(cliente);
        this.accionDefault(request, response);
    }
}
