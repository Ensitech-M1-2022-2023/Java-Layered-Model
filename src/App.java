import java.util.*;

import javax.persistence.*;

import DAO.GameAction;
import DAO.GameAdventure;
import DAO.GameType;

public class App {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-layered-model");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        GameAction gameAction = new GameAction(em);
        gameAction.setName("An action game without a name");
        
        GameAdventure gameAdventure = new GameAdventure(em);
        gameAdventure.setName("An adventure game without a name");

        GameType.create(gameAction);
        GameType.create(gameAdventure);

        printGame(em);

        System.out.println(">>>Delete game with id 1");
        GameType.delete(new Long(1));
        printGame(em);
        
        System.out.println(">>>Update game with name 'An adventure game without a name' to 'A good game'");
        GameType.update(gameAdventure.getId(), "A good game");
        printGame(em);

        tx.commit();
        em.close();
        emf.close();	
    }

    public static void printGame(EntityManager em){
        List<GameType> games = GameType.getAll();
        System.out.println("--------------------------------------");
        games.forEach((game)->{
            System.out.println(game.getId() + " : " + game.getName());
        });
        System.out.println("--------------------------------------");
    }
}
