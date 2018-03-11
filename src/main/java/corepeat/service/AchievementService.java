package corepeat.service;

import corepeat.model.AchievementProgress;

public interface AchievementService {
    void addAchievementProgress(AchievementProgress achievementProgress);

    void grantBaseProgress();
}
