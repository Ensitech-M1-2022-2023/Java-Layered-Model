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

        GameAction gameAction = new GameAction();
        gameAction.setName("An action game without a name");
        
        GameAdventure gameAdventure = new GameAdventure();
        gameAdventure.setName("An adventure game without a name");

        em.persist(gameAction);
        em.persist(gameAdventure);
        tx.commit();

        List<GameType> games = em.createNamedQuery(GameType.GET_ALL, GameType.class).getResultList();
        games.forEach((game)->{
            System.out.println("Game : " + game.getName());
        });

        em.close();
        emf.close();	
    }
}
