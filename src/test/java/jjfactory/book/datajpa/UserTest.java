package jjfactory.book.datajpa;

import jjfactory.book.datajpa.model.Team;
import jjfactory.book.datajpa.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
public class UserTest {

    @PersistenceContext
    EntityManager em;

    @Test
    @Transactional
    public void testEntity(){
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");

        em.persist(teamA);
        em.persist(teamB);

        User user1 = new User("user1",10,teamA);
        User user2 = new User("user2",20,teamB);
        User user3 = new User("user3",30,teamA);

        em.persist(user1);
        em.persist(user2);
        em.persist(user3);

        em.flush();
        em.clear();

        List<User> users = em.createQuery("select u from User u",User.class)
                .getResultList();

        for(User u: users){
            System.out.println("user = " + u);
            System.out.println("-> user.team" + u.getTeam());
        }
    }
}
