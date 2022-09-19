package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
    public DAOUser user;

    private Connection connection;
    private Statement statement;

    public DAO(String url){
        try {            
            System.out.println("Available drivers:");
            DriverManager.drivers().forEach((driver)->{
                System.out.println("\t- "+driver.getClass().getName());
            });

            connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            statement = connection.createStatement();
            
            user = new DAOUser(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
