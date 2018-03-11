package corepeat.dao;

import corepeat.model.CorepeatUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        CorepeatUser corepeatUser = session.get(CorepeatUser.class, userId);
        return corepeatUser;
    }

    @Override
    public CorepeatUser getUserByEmail(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CorepeatUser> query = builder.createQuery(CorepeatUser.class);
        Root<CorepeatUser> root = query.from(CorepeatUser.class);
        query.select(root).where(builder.equal(root.get("userEmail"), email));
        Query<CorepeatUser> q = session.createQuery(query);
        CorepeatUser corepeatUser = null;
        if (q.list().size() > 0) corepeatUser = q.getSingleResult();
        return corepeatUser;
    }

    @Override
    public Stream<CorepeatUser> getUserStream() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("SELECT b FROM CorepeatUser b", CorepeatUser.class).stream();
    }

}
