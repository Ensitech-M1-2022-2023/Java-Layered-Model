package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.Models.Game;

public class GameDAO {
    private EntityManager em; 

    GameDAO(EntityManager em){
        this.em = em;
    }
    
    public Game get(Long id){
        return em.find(Game.class, id);
    }
    
    public void update(Long id, String newName){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Game game = em.find(Game.class, id);
        em.createNamedQuery(Game.UPDATE).setParameter("oldName", game.getName()).setParameter("newName", newName).executeUpdate();
        em.refresh(game);
        tx.commit();
    }

    public List<Game> getAll(){
        List<Game> games = em.createNamedQuery(Game.GET_ALL, Game.class).getResultList();
        return games;
    }

    public void delete(Long id){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.createNamedQuery(Game.DELETE).setParameter("id", id).executeUpdate();
        tx.commit();
    }

    public void create(Game game){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(game);
        tx.commit();
    }
}
