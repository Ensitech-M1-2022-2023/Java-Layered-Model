import javax.persistence.*;

import DAO.User;

public class App {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-layered-model");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        User formation = new User();
        formation.setName("Nathan");

        em.persist(formation);

        tx.commit();

        em.close();
        emf.close();	
    }
}
