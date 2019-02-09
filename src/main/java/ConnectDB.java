import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {
    private static Connection conn = null;
    private static String dbURL = "jdbc:sqlserver://ip:1433;databaseName=FletNix";
    private static String user = "";
    private static String pass = "";
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        connection = DriverManager.getConnection(dbURL,user,pass);
        return connection;
    }
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());



        try {


            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Connection getConn() {
        return conn;
    }

    public boolean isConnected(){
        if(ConnectDB.conn != null){
            return true;
        }
        return false;
    }

}
