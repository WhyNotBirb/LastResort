import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public  class DBClient {
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://localhost:3306/test";
    static final String USER = "root";
    static final String PASS = "";

    public  Connection getConn()
    {
        Connection conn = null;
        try
        {

            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mariadb://127.0.0.1:3306/test", "root", "");

        } catch (SQLException se)
        {
            se.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return conn;
    }


}

