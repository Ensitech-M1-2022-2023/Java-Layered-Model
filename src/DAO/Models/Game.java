package DAO.Models;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="game")
@NamedQueries({
    @NamedQuery(name="RETREIVE", query="select gt from Game gt where gt.id = :id"),
    @NamedQuery(name="UPDATE", query="update Game gt set name = :newName where name = :oldName"),
    @NamedQuery(name="GET_ALL", query="select gt from Game gt"),
    @NamedQuery(name="DELETE", query="delete from Game gt where gt.id = :id"),
  })
public class Game {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;

    public final static String RETREIVE = "RETREIVE";
    public final static String UPDATE = "UPDATE";
    public final static String DELETE = "DELETE";
    public final static String GET_ALL = "GET_ALL";

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
}