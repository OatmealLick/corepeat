package corepeat.dao;

import corepeat.model.CorepeatUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.stream.Stream;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(CorepeatUser corepeatUser) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(corepeatUser);
    }

    @Override
    public CorepeatUser getUserById(Integer userId) {
        Session session = this.sessionFactory.getCurrentSession();
        CorepeatUser user = session.get(CorepeatUser.class, userId);
        return user;
    }

    @Override
    public Stream<CorepeatUser> getUserStream() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("SELECT b FROM CorepeatUser b", CorepeatUser.class).stream();
    }
}
