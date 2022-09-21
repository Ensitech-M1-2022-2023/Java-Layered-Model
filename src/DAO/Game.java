package DAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Game {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    private String name;

    @ManyToOne
    private Collection collection;

    public Game(){

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

    public Collection getCollection() {
        return collection;
    }
    public void setCollection(Collection collection) {
        this.collection = collection;
    }
}
