package repository;

import models.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDao {

    private List<Alumno> clientes;
    
    public AlumnoDao() {
        clientes = new ArrayList<>();
        
        Alumno clienteOne = new Alumno(1, "Miguel Rodrigo", "Armas Abt", "miguel.armas@unmsm.edu.pe", "938817123", 23000);
        Alumno clienteTwo = new Alumno(2, "Edinson Paolo", "Boada Cajo", "edinson.boada@unmsm.edu.pe", "938817123", 23000); 
        Alumno clienteThree = new Alumno(3, "Yanpieer Josue", "Romero Salazar", "yanpieer.romero@unmsm.edu.pe", "938817123", 23000);  
        this.clientes.add(clienteOne);
        this.clientes.add(clienteTwo);
        this.clientes.add(clienteThree);
    }

    public List<Alumno> listar() {
        return this.clientes;
    }
    
    public Alumno encontrar(Alumno cliente) {
        Alumno response = new Alumno();
        for (Alumno c: this.clientes) {
            if(cliente.getIdCliente() == c.getIdCliente()) {
                response = cliente; 
            }
        }
        return response;
    }
    
    public int insertar(Alumno cliente) {
        this.clientes.add(cliente);
        return 1;
    }
    
    public int actualizar(Alumno cliente) {
        Alumno response = cliente;
        
        for(Alumno c: this.clientes) {
            if(c.getIdCliente() == cliente.getIdCliente()) {
                this.clientes.remove(c);
            }
        }
        this.clientes.add(response);
        return 1;
    }
    
    public int eliminar (Alumno cliente) {
        this.clientes.remove(cliente);
        return 1;
    }
    
    
    private static final String SQL_SELECT = "SELECT idCliente, nombre, apellido, email, telefono, saldo"
            + " FROM cliente";

    private static final String SQL_SELECT_BY_ID = "SELECT idCliente, nombre, apellido, email, telefono, saldo"
            + " FROM cliente WHERE idCliente= ?";

    private static final String SQL_INSERT = "INSERT INTO cliente (nombre, apellido, email, telefono, saldo) "
            + "VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE cliente "
            + "SET nombre=?, apellido=?, email=?, telefono=?, saldo=? WHERE idCliente=?";
    
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE idCliente= ?";

    /*
    public List<Cliente> listar() {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            con = Conexion.getConnection();
            pstm = con.prepareStatement(SQL_SELECT);
            rs = pstm.executeQuery();

            while (rs.next()) {

                int idCliente = rs.getInt("idCliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");

                Cliente ret = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
                clientes.add(ret);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(rs);
            Conexion.close(pstm);
            Conexion.close(con);
        }
        return clientes;

    public Cliente encontrar(Cliente cliente) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {

            con = Conexion.getConnection();
            pstm = con.prepareStatement(SQL_SELECT_BY_ID);

            //proporciono el primer parámetro entero
            pstm.setInt(1, cliente.getIdCliente());
            rs = pstm.executeQuery();

            //me posiciono en el registro devuelto, de haberlo
            rs.absolute(1);
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            double saldo = rs.getDouble("saldo");

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);

        } catch (Exception ex) {

            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(rs);
            Conexion.close(pstm);
            Conexion.close(con);
        }
        return cliente;
    }

    public int insertar(Cliente cliente) {
        Connection con = null;
        PreparedStatement pstm = null;
        int rows=0;
        
        try {

            con = Conexion.getConnection();
            pstm = con.prepareStatement(SQL_INSERT);
            pstm.setString(1, cliente.getNombre());
            pstm.setString(2, cliente.getApellido());
            pstm.setString(3, cliente.getEmail());
            pstm.setString(4, cliente.getTelefono());
            pstm.setDouble(5, cliente.getSaldo());
            
            //filas afectadas
            rows=pstm.executeUpdate();
        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(pstm);
            Conexion.close(con);
        }
        return rows;
    }
    
    public int actualizar(Cliente cliente){
        Connection con = null;
        PreparedStatement pstm = null;
        int rows=0;
        
        try {

            con = Conexion.getConnection();
            pstm = con.prepareStatement(SQL_UPDATE);
            pstm.setString(1, cliente.getNombre());
            pstm.setString(2, cliente.getApellido());
            pstm.setString(3, cliente.getEmail());
            pstm.setString(4, cliente.getTelefono());
            pstm.setDouble(5, cliente.getSaldo());
            pstm.setInt(6, cliente.getIdCliente());
            
            //filas afectadas
            rows=pstm.executeUpdate();
        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(pstm);
            Conexion.close(con);
        }
        return rows;
    }

    public int eliminar(Cliente cliente){
        
        Connection con = null;
        PreparedStatement pstm = null;
        int rows=0;
        
        try {

            con = Conexion.getConnection();
            pstm = con.prepareStatement(SQL_DELETE);
            pstm.setInt(1, cliente.getIdCliente());
            
            //filas afectadas
            rows=pstm.executeUpdate();
        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(pstm);
            Conexion.close(con);
        }
        return rows;
    }
*/
}
