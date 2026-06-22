//DatabaseConnection.java
package Level_3.Task_1;
import java.sql.*;

public class DatabaseConnection{

    private static final String URL = "jdbc:mysql://localhost:3306/library_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args){
        try(Connection conn = getConn()){
            System.out.println("You connected to Mysql!");
        } catch (SQLException e){
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

}
