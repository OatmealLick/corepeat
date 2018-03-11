package corepeat.dao;

import corepeat.model.AchievementProgress;
import corepeat.model.CorepeatUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<String> getAchievementsOfUser(Integer id) {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM AchievementProgress b where b.user =" + id, AchievementProgress.class)
                .stream()
                .filter(b -> b.getProgress() >= b.getProgressCap()).map(b -> b.getAchievementName()).collect(Collectors.toList());
    }
}
