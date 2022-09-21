package DAO;

import javax.persistence.*;

@Entity
@DiscriminatorValue("action")
public class GameAction extends GameType {
    private String name;

    public GameAction(){

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
