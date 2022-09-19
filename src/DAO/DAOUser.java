package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.Models.User;

public class DAOUser {
    public static final String TABLE = "User";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";

    Statement statement;

    public DAOUser(Statement statement){
        this.statement = statement;
    }

    /*
     * Get all users
     */
    public List<User> get() throws SQLException{
        List<User> users = new ArrayList<User>();
        ResultSet result = statement.executeQuery("SELECT * FROM " + DAOUser.TABLE);
        while (result.next()) {
            User user = new User(result.getInt(DAOUser.COLUMN_ID), result.getString(DAOUser.COLUMN_NAME));
            users.add(user);
        }
        return users;
    }
    
    /*
     * Get an user with a specific id
     */
    public User get(Number id) throws SQLException{
        ResultSet result = statement.executeQuery("SELECT * FROM " + DAOUser.TABLE + " WHEN " + DAOUser.COLUMN_ID + "="+ id);
        result.next();
        return new User(result.getInt(DAOUser.COLUMN_ID), result.getString(DAOUser.COLUMN_NAME));
    }

    /*
     * Create an user
     */
    public User post(User user) throws SQLException{
        statement.executeUpdate("INSERT INTO "+ DAOUser.TABLE +"(" + DAOUser.COLUMN_NAME + ") VALUES ('" + user.login + "')", Statement.RETURN_GENERATED_KEYS);
        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();
        return new User((int) resultSet.getLong(1), user.login);
    }

    /*
     * Delete an user
     */
    public void delete(Integer id) throws SQLException{
        statement.executeUpdate("DELETE FROM "+ DAOUser.TABLE + " WHERE " + DAOUser.COLUMN_ID + "=" + id);
    }
}