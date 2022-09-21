package DAO.Models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("adventure")
public class GameAdventure extends Game {

}
