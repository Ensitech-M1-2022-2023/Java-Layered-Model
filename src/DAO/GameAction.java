package DAO;

import javax.persistence.*;

@Entity
@DiscriminatorValue("action")
public class GameAction extends GameType {
    public GameAction(){

    }
}
