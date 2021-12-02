package repository;

import models.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDao {

    private List<Alumno> alumnos;
    
    public AlumnoDao() {
        alumnos = new ArrayList<>();
        
        Alumno alumnoOne = new Alumno("A0001", "Miguel Rodrigo", "Armas Abt");
        Alumno alumnoTwo = new Alumno("A0002", "Edinson Paolo", "Boada Cajo"); 
        Alumno alumnoThree = new Alumno("A0003", "Yanpieer Josue", "Romero Salazar");
        this.alumnos.add(alumnoOne);
        this.alumnos.add(alumnoTwo);
        this.alumnos.add(alumnoThree);
    }

    public List<Alumno> listar() {
        return this.alumnos;
    }
    
    public Alumno encontrar(Alumno alumno) {
        Alumno response = new Alumno();
        for (Alumno a: this.alumnos) {
            if(alumno.getCodAlumno()== a.getCodAlumno()) {
                response = alumno; 
            }
        }
        return response;
    }
    
    public int insertar(Alumno alumno) {
        this.alumnos.add(alumno);
        return 1;
    }
    
    public int actualizar(Alumno alumno) {
        Alumno response = alumno;
        
        for(Alumno a: this.alumnos) {
            if(a.getCodAlumno()== alumno.getCodAlumno()) {
                this.alumnos.remove(a);
            }
        }
        this.alumnos.add(response);
        return 1;
    }
    
    public int eliminar (Alumno alumno) {
        this.alumnos.remove(alumno);
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
        List<Cliente> alumnos = new ArrayList<>();

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
                alumnos.add(ret);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(rs);
            Conexion.close(pstm);
            Conexion.close(con);
        }
        return alumnos;

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
