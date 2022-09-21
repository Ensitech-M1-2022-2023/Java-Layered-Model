import javax.persistence.*;

import DAO.GameAction;
import DAO.GameAdventure;

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

        em.close();
        emf.close();	
    }
}
