package repository;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String JDBC_URL = "jdbc:sqlserver://servidorsqlprueba.database.windows.net:1433;databaseName=sqlremoto;";
    private static final String JDBC_USER = "edinsonb";
    private static final String JDBC_PASSWORD = "aQ28zB4yL6Bkm5C";
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
