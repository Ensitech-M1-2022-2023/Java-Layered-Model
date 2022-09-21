import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import DAO.Collection;
import DAO.Game;

public class App {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-layered-model");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        Collection RiotGames = new Collection();

        Game leagueOfLegends = new Game();
        leagueOfLegends.setName("League of Legends");
        leagueOfLegends.setCollection(RiotGames);

        Game LeagueOfRunetera = new Game();
        LeagueOfRunetera.setName("League of Runetera");
        LeagueOfRunetera.setCollection(RiotGames);

        Set<Game> games = new HashSet<Game>();
        games.add(leagueOfLegends);

        em.persist(LeagueOfRunetera);
        em.persist(RiotGames);
        em.persist(leagueOfLegends);
        tx.commit();

        em.close();
        emf.close();	
    }
}
