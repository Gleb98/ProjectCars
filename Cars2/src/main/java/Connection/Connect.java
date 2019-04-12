package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    public static Connection getConnect() {
        String url = "jdbc:sqlserver://192.168.247.1:55808;database=StudyProjectDB";
        String login = "admin";
        String password = "admin";
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(url,login,password);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}


