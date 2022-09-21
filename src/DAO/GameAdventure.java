package DAO;

import javax.persistence.*;

@Entity
@DiscriminatorValue("adventure")
public class GameAdventure extends GameType {
    public GameAdventure(EntityManager em){
        super(em);
    }

}
