package DAO.Models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("action")
public class GameAction extends Game {

}
