package corepeat.dao;

import corepeat.model.Corepeat;
import corepeat.model.CorepeatUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CorepeatDAOImpl implements CorepeatDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCorepeat(Corepeat corepeat) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(corepeat);
    }

    @Override
    public Corepeat getCorepeatById(Integer corepeatId) {
        Session session = this.sessionFactory.getCurrentSession();
        Corepeat corepeat = session.get(Corepeat.class, corepeatId);
        return corepeat;
    }
}
