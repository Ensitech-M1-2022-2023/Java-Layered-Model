package Service;

import java.util.*;


import DAO.DAO;
import DAO.Models.Game;

public class ServiceGame {

    DAO dao;

    public ServiceGame(String confName){
        dao = new DAO(confName);
    }

    public List<Game> get(){
        return dao.game.getAll();
    }

    public Game get(Long id){
        return dao.game.get(id);
    }

    public void create(Game game){
        dao.game.create(game);
    }

    public void update(Long id, String newName){
        dao.game.update(id, newName);
    }

    public void delete(Long id){
        dao.game.delete(id);
    }
}
