package DAO;

import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="game_type")
@NamedQueries({
    @NamedQuery(name="RETREIVE", query="select gt from GameType gt where gt.id = :id"),
    @NamedQuery(name="UPDATE", query="update GameType gt set name = :newName where name = :oldName"),
    @NamedQuery(name="GET_ALL", query="select gt from GameType gt"),
    @NamedQuery(name="DELETE", query="delete from GameType gt where gt.id = :id"),
  })
public class GameType {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;

    private final static String RETREIVE = "RETREIVE";
    private final static String UPDATE = "UPDATE";
    private final static String DELETE = "DELETE";
    private final static String GET_ALL = "GET_ALL";

    private static EntityManager em; 

    public GameType(EntityManager em){
        GameType.em = em;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //GET BY ID
    public static void get(Long id){
        em.createNamedQuery(GameType.RETREIVE).setParameter("id", id).executeUpdate();
    }
    
    //UPDATE NAME BY ID
    public static void update(Long id, String newName){
        GameType game = em.find(GameType.class, id);
        em.createNamedQuery(GameType.UPDATE).setParameter("oldName", game.name).setParameter("newName", newName).executeUpdate();
        em.refresh(game);
    }

    //GET ALL
    public static List<GameType> getAll(){
        List<GameType> games = em.createNamedQuery(GameType.GET_ALL, GameType.class).getResultList();
        return games;
    }

    //DELTE BY ID
    public static void delete(Long id){
        em.createNamedQuery(GameType.DELETE).setParameter("id", id).executeUpdate();
    }

    //CREATE GAME
    public static void create(GameType game){
        em.persist(game);
    }
}