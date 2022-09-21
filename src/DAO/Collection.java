package DAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Collection {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

    public Collection(){

    }
}
