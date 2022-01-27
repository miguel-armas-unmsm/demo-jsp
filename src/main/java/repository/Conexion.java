package repository;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String JDBC_URL = "jdbc:sqlserver://unmsmserver.database.windows.net:1433;databaseName=unmsmdatabase";
    private static final String JDBC_USER = "miguelarmas";
    private static final String JDBC_PASSWORD = "l21m01j16M01L13";
    private static final String JDBC_DRIVER_CLASS_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private static BasicDataSource dataSource;

    public static DataSource getDataSource() {

        if (dataSource == null) {
            dataSource=new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            dataSource.setDriverClassName(JDBC_DRIVER_CLASS_NAME);
            dataSource.setInitialSize(50);
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {

        return getDataSource().getConnection();
    }

    public static void close(ResultSet rs) {

        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement pstm) {

        try {
            pstm.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection con) {

        try {
            con.close();
        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        }
    }
}
