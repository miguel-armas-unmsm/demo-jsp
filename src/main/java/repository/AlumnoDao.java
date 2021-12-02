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
    }
    
    private static final String SQL_SELECT = "SELECT * FROM alumnos";           

    private static final String SQL_SELECT_BY_ID = "SELECT * FROM alumnos WHERE codalu=?";
            
    private static final String SQL_INSERT = "INSERT INTO alumnos (codalu, nomalu, apealu) VALUES (?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE alumnos SET nomalu=?, apealu=? WHERE codalu=?";
    
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE codalu=?";

    
    public List<Alumno> listar() {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Alumno> alumnos = new ArrayList<>();

        try {
            con = Conexion.getConnection();
            pstm = con.prepareStatement(SQL_SELECT);
            rs = pstm.executeQuery();

            while (rs.next()) {

                String codigo = rs.getString("codalu");
                String nombre = rs.getString("nomalu");
                String apellido = rs.getString("apealu");

                Alumno ret = new Alumno(codigo, nombre, apellido);
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
    }

    public Alumno encontrar(Alumno alumno) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {                       
            con = Conexion.getConnection();
            pstm = con.prepareStatement(SQL_SELECT_BY_ID);

            //proporciono el primer parámetro entero
            pstm.setString(1, alumno.getCodAlumno());
            rs = pstm.executeQuery();                        
                   
            while (rs.next()) {

                String nombre = rs.getString("nomalu");
                String apellido = rs.getString("apealu");

                alumno.setNombre(nombre);
                alumno.setApellido(apellido);
            }

        } catch (Exception ex) {

            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(rs);
            Conexion.close(pstm);
            Conexion.close(con);
        }
        return alumno;
    }

    public int insertar(Alumno alumno) {
        Connection con = null;
        PreparedStatement pstm = null;
        int rows=0;
        
        try {           
            con = Conexion.getConnection();
            pstm = con.prepareStatement(SQL_INSERT);
            pstm.setString(1, alumno.getCodAlumno());
            pstm.setString(2, alumno.getNombre());
            pstm.setString(3, alumno.getApellido());
            
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
    
    public int actualizar(Alumno alumno){
        Connection con = null;
        PreparedStatement pstm = null;
        int rows=0;
        
        try {

            con = Conexion.getConnection();
            pstm = con.prepareStatement(SQL_UPDATE);
            pstm.setString(1, alumno.getNombre());
            pstm.setString(2, alumno.getApellido());
            pstm.setString(3, alumno.getCodAlumno());
            
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

    public int eliminar(Alumno alumno){
        
        Connection con = null;
        PreparedStatement pstm = null;
        int rows=0;
        
        try {
            con = Conexion.getConnection();
            pstm = con.prepareStatement(SQL_DELETE);
            pstm.setString(1, alumno.getCodAlumno());
            
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
}
