import java.sql.SQLException;
import java.util.List;

import DAO.DAO;
import DAO.Models.User;

public class App {

    public static void main(String[] args) throws Exception {
        DAO dao = new DAO("jdbc:sqlite:sample.db");

        printUsers(dao);
        
        User paul = dao.user.post(new User(-1, "Paul"));
        System.out.println("Paul has been created");
        
        printUsers(dao);

        dao.user.delete(paul.id);
        System.out.println("Paul has been deleted");
        
        printUsers(dao);
    }

    private static void printUsers(DAO dao){
        List<User> users;
        try {
            users = dao.user.get();
            users.forEach((user)->{
                System.out.println(user.id + ":" + user.login);
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
