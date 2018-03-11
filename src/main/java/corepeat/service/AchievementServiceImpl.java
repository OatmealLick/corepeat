package corepeat.service;

import corepeat.dao.AchievementDAO;
import corepeat.dao.UserDAO;
import corepeat.model.AchievementProgress;
import corepeat.model.CorepeatUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

public class AchievementServiceImpl implements AchievementService{

    @Autowired
    @Qualifier("achievementDAO")
    public void setAchievementDAO(AchievementDAO achievementDAO) {
        this.achievementDAO = achievementDAO;
    }

    private AchievementDAO achievementDAO;

    @Autowired
    @Qualifier("userDAO")
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    private UserDAO userDAO;

    @Override
    public void addAchievementProgress(AchievementProgress achievementProgress) {
        achievementDAO.addAchievementDao(achievementProgress);
    }

    @Override
    @Transactional
    public void grantBaseProgress() {
        Stream<CorepeatUser> stream = userDAO.getUserStream();
        stream.forEach(c -> {
            AchievementProgress progress = new AchievementProgress();
            progress.setAchievementName("Kreator");
            progress.setProgress(0);
            progress.setProgressCap(5);
            progress.setUser(c);
            achievementDAO.addAchievementDao(progress);}
            );
    }

    @Override
    @Transactional
    public List<String> getAchievementsOfUser(Integer id) {
        return achievementDAO.getAchievementsOfUser(id);
    }
}
