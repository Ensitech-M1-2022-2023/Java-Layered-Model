import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import DAO.Game;
import DAO.User;

public class App {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-layered-model");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        Game leagueOfLegends = new Game();
        leagueOfLegends.setName("League of legends");

        User nathan = new User();
        nathan.setName("Nathan");

        Set<Game> games = new HashSet<Game>();
        games.add(leagueOfLegends);
        nathan.setGames(games);

        em.persist(leagueOfLegends);
        em.persist(nathan);
        tx.commit();

        em.close();
        emf.close();	
    }
}
