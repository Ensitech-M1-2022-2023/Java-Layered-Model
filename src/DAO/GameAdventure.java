package DAO;

import javax.persistence.*;

@Entity
@DiscriminatorValue("adventure")
public class GameAdventure extends GameType {
    private String name;

    public GameAdventure(){

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
