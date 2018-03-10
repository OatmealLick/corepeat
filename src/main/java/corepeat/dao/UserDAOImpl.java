package corepeat.dao;

import corepeat.model.CorepeatUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        session.persist(corepeatUser);
    }
}
