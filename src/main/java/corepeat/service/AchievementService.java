package corepeat.service;

import corepeat.model.AchievementProgress;

import java.util.List;

public interface AchievementService {
    void addAchievementProgress(AchievementProgress achievementProgress);

    void grantBaseProgress();

    List<String> getAchievementsOfUser(Integer integer);
}
