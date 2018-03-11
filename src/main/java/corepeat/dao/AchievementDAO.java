package corepeat.dao;

import corepeat.model.AchievementProgress;

import java.util.List;

public interface AchievementDAO {

    void addAchievementDao(AchievementProgress achievementProgress);

    List<String> getAchievementsOfUser(Integer id);
}
