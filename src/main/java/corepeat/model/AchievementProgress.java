package corepeat.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ACHIEVEMENT_PROGRESS",  uniqueConstraints = {@UniqueConstraint(columnNames = {"ACHIEVEMENT_PROGRESS_ID"})})
public class AchievementProgress {

    @Id
    @Column(name = "ACHIEVEMENT_PROGRESS_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer achievementProgressId;

    @Column(name = "ACHIEVEMENT_NAME")
    private String achievementName;

    @JoinColumn(name = "USER_ID")
    @OneToOne
    private CorepeatUser user;

    @Column(name = "PROGRESS")
    private Integer progress;

    @Column(name = "PROGRESS_CAP")
    private Integer progressCap;

    public Integer getAchievementProgressId() {
        return achievementProgressId;
    }

    public void setAchievementProgressId(Integer achievementProgressId) {
        this.achievementProgressId = achievementProgressId;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    public CorepeatUser getUser() {
        return user;
    }

    public void setUser(CorepeatUser user) {
        this.user = user;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getProgressCap() {
        return progressCap;
    }

    public void setProgressCap(Integer progressCap) {
        this.progressCap = progressCap;
    }
}
