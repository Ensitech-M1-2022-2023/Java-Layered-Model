package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {
    public GameDAO game;

    public DAO(String confName){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-layered-model");
        EntityManager  em = emf.createEntityManager();

        game = new GameDAO(em);
    }
}
