package repository;

import models.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Detalle;

public class AlumnoDao {

    private List<Alumno> alumnos;
    
    public AlumnoDao() {
    }
    
    private static final String SQL_SELECT = "SELECT * FROM alumnos";           

    private static final String SQL_SELECT_BY_ID = "SELECT * FROM alumnos WHERE codalu=?";
            
    private static final String SQL_INSERT = "INSERT INTO alumnos (codalu, nomalu, apealu) VALUES (?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE alumnos SET nomalu=?, apealu=? WHERE codalu=?";
    
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE codalu=?";

    private static final String SELECT_STUDENT_COURSE = "SELECT \n" +
      "\tc.codcur as codigo,\n" +
      "\tc.nomcur as nombre, \n" +
      "\tac.nota as nota\n" +
      "\tFROM [dbo].[cursos] as c\n" +
      "\tJOIN [dbo].[alu_cur] as ac\n" +
      "\tON c.codcur = ac.codcur\n" +
      "\tWHERE ac.codalu = ?";
    
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
    
  public List<Detalle> obtenerDetalle(String codigoAlumno) {
    List<Detalle> details = new ArrayList<>();

    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    try {
      con = Conexion.getConnection();
      con.setAutoCommit(false);

      pstm = con.prepareStatement(SELECT_STUDENT_COURSE);
      pstm.setString(1, codigoAlumno);
      rs = pstm.executeQuery();

      while (rs.next()) {
        Detalle detail = new Detalle(rs.getString("codigo"), rs.getString("nombre"), rs.getInt("nota"));
        details.add(detail);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return details;
  }

  
}
