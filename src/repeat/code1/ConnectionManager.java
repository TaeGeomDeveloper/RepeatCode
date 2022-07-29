package repeat.code1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static Connection getConnection(){

        Connection con = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbcURL = "jdbc:mysql://localhost:3306/gisa";
        String id = "root";
        String pwd = "1234";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(jdbcURL,id,pwd);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }
}
