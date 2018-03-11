package corepeat.dao;

import corepeat.model.AchievementProgress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AchievementDAOImpl implements AchievementDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAchievementDao(AchievementProgress achievementProgress) {
        Session session = sessionFactory.getCurrentSession();
        session.save(achievementProgress);
    }
}
