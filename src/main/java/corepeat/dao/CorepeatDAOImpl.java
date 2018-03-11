package corepeat.dao;

import corepeat.model.Corepeat;
import corepeat.model.CorepeatUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CorepeatDAOImpl implements CorepeatDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCorepeat(Corepeat corepeat) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(corepeat);
    }

    @Override
    public Corepeat getCorepeatById(Integer corepeatId) {
        Session session = this.sessionFactory.getCurrentSession();
        Corepeat corepeat = session.get(Corepeat.class, corepeatId);
        return corepeat;
    }

    @Override
    public List<Corepeat> getCorepeats() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Corepeat> query = builder.createQuery(Corepeat.class);
        Root<Corepeat> root = query.from(Corepeat.class);
        query.select(root);
        Query<Corepeat> q = session.createQuery(query);
        List<Corepeat> corepeats = q.list();
        return corepeats;
    }
}
