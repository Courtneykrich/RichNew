package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private Connection conn;
    public DBConnector() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject?" +
                    "user=root&password=Herb13*L0ve&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    public Connection getConn() {
        return this.conn;
    }
}
