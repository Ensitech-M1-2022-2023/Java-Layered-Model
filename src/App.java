import java.util.*;

import javax.persistence.EntityManager;

import DAO.Models.Game;
import DAO.Models.GameAction;
import DAO.Models.GameAdventure;
import Service.Service;

public class App {
    public static void main(String[] args) throws Exception {
        Service service = new Service("java-layered-model");

        Game gameA = new Game();
        gameA.setName("gameA");
        Game gameB = new GameAction();
        gameB.setName("gameB");
        Game gameC = new GameAction();
        gameC.setName("gameC");
        Game gameD = new GameAdventure();
        gameD.setName("gameD");

        service.game.create(gameA);
        service.game.create(gameB);
        service.game.create(gameC);
        service.game.create(gameD);

        service.game.delete(gameB.getId());

        service.game.update(gameA.getId(), "gameAUpdated");

        List<Game> games = service.game.get();
        games.forEach((_game)->{
            System.out.println(_game.getName());
        });

        Game bestGame = service.game.get(new Long(4));
        System.out.println("Best game is " + bestGame.getName());
    }
}
